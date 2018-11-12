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


    public Dispenser() {
        this.drinks = new TreeMap<Drink, Boolean>();
        this.stock = new TreeMap<Ingredient, Integer>();
    }

    public void Restock() {
        for(Ingredient ingredient:stock.keySet()){
            stock.put(ingredient, inventoryMax);
        }
    }

    public void addDrink(Drink drink) {
        drinks.put(drink, false);
    }

    public void addIngredient(Ingredient ingredient){
        stock.put(ingredient, inventoryMax);
    }
    public void printDirectory(){
        System.out.println("Inventory:");
        for (Ingredient i:stock.keySet()){
            System.out.printf("%s, %d\n", i.getName(),stock.get(i));
        }
        System.out.println("Menu:");
        int drink_number = 1;
        for (Drink d:drinks.keySet()){

            System.out.printf("%d, %s, $%.2f, %b\n", drink_number++,d.getName(), d.getPrice(),inStock(d));
        }
    }

    public boolean inStock(Drink drink) {
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

    public String getDrinkName(int drink_number){
        Drink drink = (Drink)drinks.keySet().toArray()[drink_number-1];
        return drink.getName();
    }

    public boolean Dispend(int drink_number){
        Drink drink = (Drink)drinks.keySet().toArray()[drink_number-1];
        if (drinks.get(drink) && inStock(drink)){
            HashMap<Ingredient, Integer> recipe = drink.getIngredients();
            for (Ingredient i : recipe.keySet()) {
                int remainder = stock.get(i) - recipe.get(i);
                stock.put(i, remainder);
            }
            return true;
        }
        else {
            return false;
        }
    }
}
