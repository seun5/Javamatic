/**
 * Created by eunsangg10 on 11/7/18.
 * This is the implementation of a Drink object
 */


import java.util.*;

public class Drink implements Comparable<Drink>{
    private String name;
    private HashMap<Ingredient,Integer> ingredients;
    private Boolean stock = false;

    public Drink(String name){
        this.name = name;
        this.ingredients = new HashMap<Ingredient, Integer>();
    }

    public String getName(){
        return name;
    }
    public HashMap getIngredients(){
        return ingredients;
    }


    public void addIngredient(Ingredient ingredient, int amount){
        ingredients.put(ingredient, amount);
    }

    public double getPrice(){
        double price = 0;
        for(Ingredient i: ingredients.keySet()){
            price += i.getCost() * ingredients.get(i);
        }
        return price;
    }
    @Override
    public int compareTo(Drink other) {
        return name.compareTo(other.getName());
    }




}
