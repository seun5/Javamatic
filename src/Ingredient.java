
/**
 * Created by eunsangg10 on 11/7/18.
 */


public class Ingredient implements Comparable<Ingredient>{
    private String name;
    private double  cost;
    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
    public String getName(){
        return name;
    }
    public double getCost(){
        return cost;
    }

    @Override
    public int compareTo(Ingredient other) {
        return name.compareTo(other.getName());
    }

}
