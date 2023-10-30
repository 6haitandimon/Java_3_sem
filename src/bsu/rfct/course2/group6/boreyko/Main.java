package bsu.rfct.course2.group6.boreyko;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;
//Sandwich/Sausage/Cheese Tea/Black Cake/Chocolate
public class Main {
    public static void main(String[] args) {
        boolean cals = Arrays.stream(args).anyMatch("-calories"::equals);
        Scanner sc = new Scanner(System.in);
        System.out.println("Input brackfast:");

        try{
            Food[] food = new Food[12];

            // Class<Sandwich> sandwichClass = Sandwich.class;
            // Field[] declaFields = sandwichClass.getDeclaredFields();
            // for(Field field : declaFields){
            //     System.out.println(field);
            // }
            
            Class<Sandwich> sandwichClass = Sandwich.class;
            //Field filling1 = sandwichClass.getDeclaredField("sausage");
            //Field filling2 = sandwichClass.getDeclaredField("cheese");
            //Field filling3 = sandwichClass.getDeclaredField("butter");
            
            //filling1.setAccessible(true);
            //filling2.setAccessible(true);
            //filling3.setAccessible(true);
            
            String buff = sc.nextLine();
            String[] input = buff.split(" ");
            int itemSoFar = 0;
            for(String arg : input){
                String[] parts = arg.split("/");
                if(parts[0].equals("Sandwich")){
                    food[itemSoFar] = new Sandwich(parts[1].toString(), parts[2].toString());
                    itemSoFar++;
                }
                else if(parts[0].equals("Tea")){
                    if(parts[1].equals("Black"))
                        food[itemSoFar] = new Tea(Tea.black);
                    else if(parts[1].equals("Green"))
                        food[itemSoFar] = new Tea(Tea.green);
                    else 
                        food[itemSoFar] = new Tea(Tea.blue);
                    itemSoFar++;
                }
                else if(parts[0].equals("Cake")){
                    if(parts[1].equals("Caramel"))
                        food[itemSoFar] = new Cake(Cake.caramel);
                    else if(parts[1].equals("Chocolate"))
                        food[itemSoFar] = new Cake(Cake.chocolate);
                    else 
                        food[itemSoFar] = new Cake(Cake.creamy);
                    itemSoFar++;
                }
            }

            Arrays.sort(food, 0, itemSoFar, (Food x, Food y) -> {
                return y.toString().length() - x.toString().length();
            });

            int sumCalories = 0;
            for (int i = 0; i < itemSoFar; i++) {
                if(food[i] != null){
                    int curCalories = food[i].CalculateCalories();
                    food[i].Consume();
                    sumCalories += curCalories;
                }
            }
            if (cals){
                System.out.printf("Sum of calories: " + sumCalories);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
