package machine;

import java.util.Arrays;
import  java.util.Scanner;

public class CoffeeMachine {

    static int water = 200;
    static int milk = 50;
    static int  coffeeBeans = 15;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //stage 1
        // makingCofee();

        //stage 2
       /* System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        calculatingIngredient(cups); */

        // stage 3
        System.out.println("Write how many ml of water the coffee machine has: ");
        int mlOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int mlOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int gOfCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int numOfCups = scanner.nextInt();
        calculateNumberOfServing(mlOfWater, mlOfMilk, gOfCoffee, numOfCups);

    }

    public static void makingCofee (){
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }

    public static void calculatingIngredient (int cups){
        System.out.println("For " + cups +  " cups of coffee you will need:\n" +
                cups * water +  " ml of water\n" +
                cups * milk  +  " ml of milk\n" +
                cups * coffeeBeans  +  " g of coffee beans");
    }

    public static void calculateNumberOfServing(int water, int milk, int coffee, int cups) {
        int[] ingredients = new int[3];

        ingredients[0] = water / 200;;
        ingredients[1] = milk / 50;
        ingredients[2] = coffee / 15;

        Arrays.sort(ingredients);

        if (ingredients[0] == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        if (ingredients[0] > cups) {
            System.out.println("Yes, I can make that amount of coffee " + "(and even " + (ingredients[0] - cups) + " more than that)");
        }
        if (ingredients[0] < cups) {
            System.out.println("No, I can make only " + ingredients[0] + " cup(s) of coffee");
        }
    }
}
