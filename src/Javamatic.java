/**
 * Created by eunsangg10 on 11/7/18.
 * Run Javamatic Machine
 */


import java.util.Scanner;


public class Javamatic {
    /**
     * Entry point for the program
     * @param args arguments(will not be used for the program)
     */
    public static void main(String[] args) {
        // Set up dispenser through setup method
        Dispenser dispenser = setup();

        // Use scanner to read standard input
        Scanner scanner = new Scanner(System.in);


        boolean blank_line = false;
        while (true) {
            if (!blank_line)dispenser.printDirectory();
            String command = scanner.nextLine();
            if (command.length() == 0) {
                blank_line = true;
                continue;
            }
            blank_line = false;
            if (command.length() == 1) {
                char run = command.charAt(0);
                if (run == 'r' || run == 'R') {
                    dispenser.Restock();
                } else if (run == 'q' || run == 'Q') {
                    break;
                } else if ((int) run >= (int) '0' && (int) run <= (int) '6') {
                    int drinkNum = (int) run - (int) '0';
                    String drink = dispenser.getDrinkName(drinkNum);
                    if (dispenser.Dispend(drinkNum)) {
                        System.out.printf("Dispensing: %s\n", drink);
                    } else {
                        System.out.printf("Out of stock: %s\n", drink);
                    }
                } else {
                    System.out.printf("Invalid Selection: %s \n", command);
                }
            } else {
                System.out.printf("Invalid Selection: %s \n", command);
            }
        }
    }

    /**
     * Returns a Coffee Dispenser with ingredients and drinks set up
     * @return Dispenser that is fully
     */
    private static Dispenser setup() {
        Dispenser dispenser = new Dispenser();

        // Ingredients
        Ingredient coffee = new Ingredient("Coffee", 0.75);
        Ingredient decafCoffee = new Ingredient("Decaf Coffee", 0.75);
        Ingredient sugar = new Ingredient("Sugar", 0.25);
        Ingredient cream = new Ingredient("Cream", 0.25);
        Ingredient steamedMilk = new Ingredient("Steamed Milk", 0.35);
        Ingredient foamedMilk = new Ingredient("Foamed Milk", 0.35);
        Ingredient espresso = new Ingredient("Espresso", 1.10);
        Ingredient cocoa = new Ingredient("Cocoa", 0.90);
        Ingredient whippedCream = new Ingredient("Whipped Cream", 1.00);

        //Drink 1
        Drink Coffee = new Drink("Coffee");
        Coffee.addIngredient(coffee, 3);
        Coffee.addIngredient(sugar, 1);
        Coffee.addIngredient(cream, 1);

        //Drink 2
        Drink DecafCoffee = new Drink("Decaf Coffee");
        DecafCoffee.addIngredient(decafCoffee, 3);
        DecafCoffee.addIngredient(sugar, 1);
        DecafCoffee.addIngredient(cream, 1);

        //Drink 3
        Drink caffeLatte = new Drink("Caffe Latte");
        caffeLatte.addIngredient(espresso, 2);
        caffeLatte.addIngredient(steamedMilk, 1);

        //Drink 4
        Drink americano = new Drink("Caffe Americano");
        americano.addIngredient(espresso, 3);

        //Drink 5
        Drink caffeMocha = new Drink("Caffe Mocha");
        caffeMocha.addIngredient(espresso, 1);
        caffeMocha.addIngredient(cocoa, 1);
        caffeMocha.addIngredient(steamedMilk, 1);
        caffeMocha.addIngredient(whippedCream, 1);

        //Drink 6
        Drink cappuccino = new Drink("Cappucino");
        cappuccino.addIngredient(espresso, 2);
        cappuccino.addIngredient(steamedMilk, 1);
        cappuccino.addIngredient(foamedMilk, 1);

        //Dispenser Setup - addDrinks
        dispenser.addDrink(Coffee);
        dispenser.addDrink(DecafCoffee);
        dispenser.addDrink(caffeLatte);
        dispenser.addDrink(americano);
        dispenser.addDrink(caffeMocha);
        dispenser.addDrink(cappuccino);

        //Dispenser Setup - addStock
        dispenser.addIngredient(coffee);
        dispenser.addIngredient(sugar);
        dispenser.addIngredient(cream);
        dispenser.addIngredient(decafCoffee);
        dispenser.addIngredient(cocoa);
        dispenser.addIngredient(whippedCream);
        dispenser.addIngredient(steamedMilk);
        dispenser.addIngredient(foamedMilk);
        dispenser.addIngredient(espresso);
        return dispenser;

    }
}
