/**
 * Created by eunsangg10 on 11/7/18.
 * This is the implementation of a Drink object
 */


import java.util.*;

public class Drink implements Comparable<Drink> {
    private String name;
    private HashMap<Ingredient, Integer> ingredients;

    /**
     * Constructor for Drink
     *
     * @param name of the drink
     */
    public Drink(String name) {
        this.name = name;
        this.ingredients = new HashMap<Ingredient, Integer>();
    }

    /**
     * Returns name of the drink
     *
     * @return name of the drink
     */
    public String getName() {
        return name;
    }

    /**
     * return
     *
     * @return map of ingredients
     */
    public HashMap getIngredients() {
        return ingredients;
    }

    /**
     * Add new ingredient to the recipe
     *
     * @param ingredient New Ingredient
     * @param amount     Amount need in the recipe
     */
    public void addIngredient(Ingredient ingredient, int amount) {
        ingredients.put(ingredient, amount);
    }

    /**
     * Return the total cost of the drink
     *
     * @return price of the drink
     */
    public double getPrice() {
        double price = 0;
        for (Ingredient i : ingredients.keySet()) {
            price += i.getCost() * ingredients.get(i);
        }
        return price;
    }

    /**
     * Comparable for sorting
     *
     * @param other compare
     * @return drink with sorted name
     */
    @Override
    public int compareTo(Drink other) {
        return name.compareTo(other.getName());
    }


}
