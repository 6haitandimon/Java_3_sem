package bsu.rfct.course2.group6.boreyko;

import java.util.HashMap;
import java.util.Objects;

public class Cake extends Food{
    private String icing = null;
    
    public static final String chocolate = "Chocolate";
    public static final String creamy = "Creamy";
    public static final String caramel = "Caramel";

    private static HashMap<String, Integer> icing2count;
    static{
        icing2count = new HashMap<>();
        icing2count.put(chocolate, 0);
        icing2count.put(creamy, 0);
        icing2count.put(caramel, 0);
    }

    private static final HashMap<String, Integer> icing2calories;
    static{
        icing2calories = new HashMap<>();
        icing2calories.put(chocolate, 100);
        icing2calories.put(creamy, 200);
        icing2calories.put(caramel, 300);
    }

    public Cake(String Icing) throws InvalidIcingException{
        if(icing2count.get(Icing) != null){
            this.calories = icing2calories.get(Icing);
            icing2count.put(Icing, icing2count.get(Icing) + 1);
            icing = Icing;
        }
    }

    public static int Amount(String color){
        return icing2count.get(color);
    }

    @Override
    public String toString(){
        return "Tea{" +
        "color='" + icing + '\'' +
        ", calories=" + calories +
        '}';
    }

    @Override
    public void Consume(){
        System.out.println(icing + " " + name + " has been eaten.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return Objects.equals(icing, cake.icing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icing);
    }

    @Override
    public int CalculateCalories() {
        return calories;
    }
}
