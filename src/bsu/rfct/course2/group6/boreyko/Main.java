package bsu.rfct.course2.group6.boreyko;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean cals = Arrays.stream(args).anyMatch("-calories"::equals);
        try{
            Food[] food = new Food[12];

            // Class<Sandwich> sandwichClass = Sandwich.class;
            // Field[] declaFields = sandwichClass.getDeclaredFields();
            // for(Field field : declaFields){
            //     System.out.println(field);
            // }
            
            Class<Sandwich> sandwichClass = Sandwich.class;
            Field filling1 = sandwichClass.getDeclaredField("sausage");
            Field filling2 = sandwichClass.getDeclaredField("cheese");
            Field filling3 = sandwichClass.getDeclaredField("butter");
            
            filling1.setAccessible(true);
            filling2.setAccessible(true);
            filling3.setAccessible(true);

            food[0] = new Sandwich(filling1.get(sandwichClass).toString(), filling2.get(sandwichClass).toString());
            food[1] = new Sandwich(filling2.get(sandwichClass).toString(), filling3.get(sandwichClass).toString());
            food[2] = new Sandwich(filling1.get(sandwichClass).toString(), filling3.get(sandwichClass).toString());
            food[3] = new Sandwich(filling1.get(sandwichClass).toString(), filling1.get(sandwichClass).toString());
            food[4] = new Tea(Tea.black);
            food[5] = new Tea(Tea.green);
            food[6] = new Tea(Tea.blue);
            food[7] = new Tea(Tea.blue);
            food[8] = new Tea(Tea.blue);
            food[9] = new Cake(Cake.caramel);
            food[10] = new Cake(Cake.chocolate);
            food[11] = new Cake(Cake.creamy);

            Arrays.sort(food, (Food x, Food y) -> {
                return y.toString().length() - x.toString().length();
            });

            int sumCalories = 0;
            for (int i = 0; i < 10; i++) {
                int curCalories = food[i].CalculateCalories();
                food[i].Consume();
                sumCalories += curCalories;
            }
            if (cals){
                System.out.printf("Sum of calories: " + sumCalories);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
