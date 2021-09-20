package machine;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner sc = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;


    public static void main(String[] args) {


        //int cups = sc.nextInt();  2nd stage

        // instruction1(); till the stage 3
        // System.out.println(ingredientsCalculator(cups)); - 2nd stage

        //  Stage 3/6: Estimate the number of servings
        /*  till the stage 3
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:  ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:  ");
        int beans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:  ");
        int cups = sc.nextInt();

        System.out.println(numbersOfServing(water,milk,beans,cups)); */

        // stage 4


        // instruction2();     stage 4

        instruction3();

        String ch = "";
        //ch = sc.next();
        do {
            //instruction3();
            //System.out.println("Enter choice:");
            ch = sc.next();
            if ((ch.equals("exit"))) {
                break;
            } else {
                //System.out.println("else  ");
                choice(ch);
            }
            instruction3();
        } while (ch != "exit");

    }

    public static void instruction1() {      // stage 3
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!\n");
    }

    public static String ingredientsCalculator(int cups) {  //stage 2
        int water = cups * 200;
        int milk = cups * 50;
        int beans = cups * 15;

        System.out.println("For " + cups + " cups of coffee you will need:");
        String cofee = "" + water + " ml of water\n" + milk + " ml of milk\n" + beans + " g of coffee beans\n";

        return cofee;
    }

    public static String numbersOfServing(int water, int milk, int beans, int cups) {  // stage 3
        //200,50,15

        int dividedWater = (int) water / 200; //1,5
        int dividedMilk = (int) milk / 50;    // 1,15
        int dividedBeans = (int) beans / 15;  // 6,8

        int[] numbers = {dividedWater, dividedMilk, dividedBeans};
        Arrays.sort(numbers);
        // System.out.println(Arrays.toString(numbers));

        // provjerava je li barem 1 sastojak veći od potrebne doze, ali i broj šalica veći od najmanjeg mogućeg sastojka
        // - ako je bilo koji sastojak manji od doze, prvi broij u polju će biti 0 i to je broj mogućih šalica
        // i provjera jesu li sve vrijednosti 0, a broj šalica veći od 0 -> to je za test primjer 4 

        if ((((water >= 200 || milk >= 50 || beans >= 15)) && (cups > numbers[0])) || (water == 0 && milk == 0 && beans == 0 && cups > 0)) {
            String zeroCups = "No, I can make only " + numbers[0] + " cup(s) of coffee";
            return (zeroCups);

            //ako je barem jedan sastojak kad se podijeli sa 200,50 ili 15 jednak broju šalica   //

        } else if ((dividedWater == cups) || (dividedMilk == cups) || (dividedBeans == cups)) {
            String enough = "Yes, I can make that amount of coffee";
            return (enough);

        } else if ((dividedWater > cups) && (dividedMilk > cups) && (dividedBeans > cups)) {
            int n = numbers[0] - cups;

            String more = "Yes, I can make that amount of coffee (and even " + n + " more than that)";
            return more;
        }
        return "";
    }
    //stage 3 finished

    //stage 4 starts

    public static void instruction2() {
        System.out.println("The coffee machine has:\n" +
                "400 ml of water\n" +
                "540 ml of milk\n" +
                "120 g of coffee beans\n" +
                "9 disposable cups\n" +
                "$550 of money\n" +
                "Write action (buy, fill, take): ");
    }

    public static void choice(String choice) {
        switch (choice) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                print(water, milk, beans, cups, money);
            case "exit":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  ");
        String c = sc.next();

        switch (c) {
            case "1":
                water -= 250;
                beans -= 16;
                money += 4;
                cups -= 1;
                break;
            case "2":
                water -= 350;
                milk -= 75;
                beans -= 20;
                money += 7;
                cups -= 1;
                break;
            case "3":
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                cups -= 1;
                break;
            case "back":
                instruction3();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        // print(water,milk,beans,cups,money); for stage 4
        calculateIfEnough(c, water, milk, beans, cups, money); // stage 5
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        int w = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:  ");
        int m = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to  ");
        int b = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int c = sc.nextInt();

        water += w;
        milk += m;
        beans += b;
        cups += c;
       // print(water, milk, beans, cups, money);

    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
       // print(water, milk, beans, cups, money);
    }

    public static void print(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:\n" + water +
                " ml of water\n" + milk +
                " ml of milk\n" + beans +
                " g of coffee beans\n" + cups +
                " disposable cups\n" +
                "$" + money + " of money\n");
    }

    //stage 4 finished

    public static void calculateIfEnough(String c, int w, int m, int b, int cup, int mon) {

        if (water >= 0 && milk >= 0 && beans >= 0 && cups >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            if (c.equals("1")) {
                if (w < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (m < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (b < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cup < 0) {
                    System.out.println("Sorry, not enough cups!");
                }
                water += 250;
                beans += 16;
                money -= 4;
                cups += 1;

            } else if (c.equals("2")) {
                if (w < 0) {
                    System.out.println("Sorry, not enough water LATE!");
                } else if (m < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (b < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cup < 0) {
                    System.out.println("Sorry, not enough cups!");
                }
                water += 350;
                milk += 75;
                beans += 20;
                money -= 7;
                cups += 1;
            } else {
                if (w < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (m < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (b < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (cup < 0) {
                    System.out.println("Sorry, not enough cups!");
                }
                water += 200;
                milk += 100;
                beans += 12;
                money -= 6;
                cups += 1;
            }
        }
    }

    public static void instruction3() {
        
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}




/*SIMPLE SOLUTION for stage 3
*
* package machine;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Write how many ml of water the coffee machine has: ");
        int mlOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int mlOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int gOfCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int numOfCups = scanner.nextInt();
        calculator(mlOfWater, mlOfMilk, gOfCoffee, numOfCups);

    }

    public static void calculator(int water, int milk, int coffee, int cups) {
        int[] array = new int[3];

        array[0] = water / 200;;
        array[1] = milk / 50;
        array[2] = coffee / 15;

        Arrays.sort(array);

        if (array[0] == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        if (array[0] > cups) {
            System.out.println("Yes, I can make that amount of coffee " + "(and even " + (array[0] - cups) + " more than that)");
        }
        if (array[0] < cups) {
            System.out.println("No, I can make only " + array[0] + " cup(s) of coffee");
        }

    }
}
* */


