
/**
 * Created by eunsangg10 on 11/7/18.
 * This is an implementation of an ingredient object
 */


public class Ingredient implements Comparable<Ingredient> {
    private String name;
    private double cost;

    /**
     * Constructor for the class ingredient
     *
     * @param name name of ingredient
     * @param cost cost of one unit of hte ingredient
     */
    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Return name of the ingredient
     *
     * @return name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Return cost of the ingredient
     *
     * @return cost of the ingredient
     */
    public double getCost() {
        return cost;
    }

    @Override
    public int compareTo(Ingredient other) {
        return name.compareTo(other.getName());
    }

}
