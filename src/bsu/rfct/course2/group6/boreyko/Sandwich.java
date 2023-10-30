package bsu.rfct.course2.group6.boreyko;

import java.util.HashMap;
import java.util.Objects;

public class Sandwich extends Food{
    private String filling = null;
    
    private static final String sausage = "Sausage";
    private static final String cheese = "Cheese";
    private static final String butter = "Butter";

    private static HashMap<String, Integer> filling2count;
    static{
        filling2count = new HashMap<>();
        filling2count.put(sausage, 0);
        filling2count.put(cheese, 0);
        filling2count.put(butter, 0);
    }

    private static final HashMap<String, Integer> filling2calories;
    static{
        filling2calories = new HashMap<>();
        filling2calories.put(sausage, 150);
        filling2calories.put(cheese, 250);
        filling2calories.put(butter, 270);
    }

    public Sandwich(String Filling1, String Filling2) throws InvalidFillingException{
        if(filling2count.get(Filling1) != null && filling2count.get(Filling2) != null){
            this.calories = filling2calories.get(Filling1) + filling2calories.get(Filling2);
            filling2count.put(Filling1, filling2count.get(Filling1) + 1);
            filling2count.put(Filling2, filling2count.get(Filling2) + 1);
            filling = Filling1 + " " + Filling2;
            this.name = "Sandwich";
        }
    }

    public static int Amount(String filling){
        return filling2count.get(filling);
    }

    @Override
    public String toString(){
        return "Sandwich{" +
        "Fillng='" + filling + '\'' +
        ", calories=" + calories +
        '}';
    }

    @Override
    public void Consume(){
        System.out.println(filling + " " + name + " has been eaten.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sandwich sandwich = (Sandwich) o;
        return Objects.equals(filling, sandwich.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filling);
    }

    @Override
    public int CalculateCalories() {
        return calories;
    }
}
