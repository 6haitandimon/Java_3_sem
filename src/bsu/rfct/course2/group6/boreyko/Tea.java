package bsu.rfct.course2.group6.boreyko;

import java.util.HashMap;
import java.util.Objects;

public class Tea extends Food{
    
    private String color = null;
    
    public static final String black = "Black";
    public static final String green = "Green";
    public static final String blue = "Blue";

    private static HashMap<String, Integer> color2count;
    static{
        color2count = new HashMap<>();
        color2count.put(black, 0);
        color2count.put(green, 0);
        color2count.put(blue, 0);
    }

    private static final HashMap<String, Integer> color2calories;
    static{
        color2calories = new HashMap<>();
        color2calories.put(black, 100);
        color2calories.put(green, 200);
        color2calories.put(blue, 300);
    }

    public Tea(String Color) throws InvalidColorException{
        if(color2count.get(Color) != null){
            this.calories = color2calories.get(Color);
            color2count.put(color, color2count.get(Color) + 1);
            color = Color;
            this.name = "Tea";
        }
    }

    public static int Amount(String color){
        return color2count.get(color);
    }

    @Override
    public String toString(){
        return "Tea{" +
        "color='" + color + '\'' +
        ", calories=" + calories +
        '}';
    }

    @Override
    public void Consume(){
        System.out.println(color + " " + name + " has been eaten.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea tea = (Tea) o;
        return Objects.equals(color, tea.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public int CalculateCalories() {
        return calories;
    }
}
