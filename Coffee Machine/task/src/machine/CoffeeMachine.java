package machine;
import  java.util.Scanner;

public class CoffeeMachine {

    static int water = 200;
    static int milk = 50;
    static int coffeeBeans = 15;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //stage 1
        makingCofee();

        //stage 2
        System.out.println("Write how many cups of coffee you will need:");
        int beans = scanner.nextInt();
        calculatingIngredient(beans);
        // pitanja : napraviti u mainu unos broja šalica pa poslati kao argument ?
        //           voda, mlijeko i zrna kave staviti kao statičke varijable iznad maina ?
        //           promijeniti ime argumenta u funkciji (bean) ? koristiti this ?



        
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

    public static void calculatingIngredient (int beans){
        System.out.println("For" + beans +  " cups of coffee you will need:\n" +
                beans * 200 +  " ml of water\n" +
                beans * 50  +  " ml of milk\n" +
                beans * 15  +  " g of coffee beans");
    }
}
