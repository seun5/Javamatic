/**
 * Created by eunsangg10 on 11/7/18.
 * This is an implementation of a coffee dispenser
 */


import java.util.HashMap;
import java.util.TreeMap;
import java.util.SortedMap;


public class Dispenser {
    private final int inventoryMax = 10;

    private SortedMap<Drink, Boolean> drinks;
    private SortedMap<Ingredient, Integer> stock;

    /**
     * Constructor for Dispenser
     */
    public Dispenser() {
        this.drinks = new TreeMap<>();
        this.stock = new TreeMap<>();
    }

    /**
     * Restock function to restock the inventory
     */
    public void Restock() {
        for (Ingredient ingredient : stock.keySet()) {
            stock.put(ingredient, inventoryMax);
        }
    }

    /**
     * Add a new type of drink to the dispenser
     *
     * @param drink to add to the machine
     */
    public void addDrink(Drink drink) {
        drinks.put(drink, false);
    }

    /**
     * Add a new type of ingredient to the inventory
     *
     * @param ingredient ingredient added to inventory
     */
    public void addIngredient(Ingredient ingredient) {
        stock.put(ingredient, inventoryMax);
    }

    /**
     * Print the existing inventory, and the available drinks
     */
    public void printDirectory() {
        System.out.println("Inventory:");
        for (Ingredient i : stock.keySet()) {
            System.out.printf("%s, %d\n", i.getName(), stock.get(i));
        }
        System.out.println("Menu:");
        int drink_number = 1;
        for (Drink d : drinks.keySet()) {

            System.out.printf("%d, %s, $%.2f, %b\n", drink_number++, d.getName(), d.getPrice(), inStock(d));
        }
    }

    /**
     * Adjust the availability of the drink
     *
     * @param drink Type of Drink
     * @return the avaialbility of the drink
     */
    private boolean inStock(Drink drink) {
        HashMap<Ingredient, Integer> recipe = drink.getIngredients();
        for (Ingredient i : recipe.keySet()) {
            if (recipe.get(i) > stock.get(i)) {
                drinks.put(drink, false);
                return false;
            }
        }
        drinks.put(drink, true);
        return true;
    }

    /**
     * Return the drink name
     *
     * @param drink_number Initial Drink Number
     * @return Drink Name
     */
    public String getDrinkName(int drink_number) {
        Drink drink = (Drink) drinks.keySet().toArray()[drink_number - 1];
        return drink.getName();
    }

    /**
     * Given a drink number, dispend the drink with that drink number
     *
     * @param drink_number drink_number that will be dispended
     * @return true if drink in stock, and false if not in stock
     */
    public boolean Dispend(int drink_number) {
        Drink drink = (Drink) drinks.keySet().toArray()[drink_number - 1];
        if (drinks.get(drink)) {
            HashMap<Ingredient, Integer> recipe = drink.getIngredients();
            for (Ingredient i : recipe.keySet()) {
                int remainder = stock.get(i) - recipe.get(i);
                stock.put(i, remainder);
            }
            return true;
        } else {
            return false;
        }
    }
}
