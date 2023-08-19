package bsu.rfct.course2.group6.boreyko;

import java.util.HashMap;
import java.util.Map;

public class Tea extends Food{
    
    private String color = null;

    private static HashMap<String, Integer> color2count;
    static{
        color2count = new HashMap<>();
        color2count.put("Black", 0);
        color2count.put("Green", 0);
        color2count.put("Blue", 0);
    }

    private static final HashMap<String, Integer> color2calories;
    static{
        color2calories = new HashMap<>();
        color2calories.put("Black", 100);
        color2calories.put("Green", 200);
        color2calories.put("Blue", 300);
    }

    public Tea(String Color) throws InvalidColorException{
        if(color2count.get(Color) != null){
            this.calories = color2calories.get(Color);
            color2count.put(color, color2count.get(Color) + 1);
            color = Color;
        }
    }

    public int Amount(){
        return colo
    }
}
