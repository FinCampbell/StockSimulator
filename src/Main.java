import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Market m = new Market();

        Stock[] stocks = m.getStocks();

        Portfolio p1 = new Portfolio();

        Scanner s = new Scanner(System.in);
        Boolean active = true;

        while(active == true) {
            System.out.println("-----------------------------------");
            System.out.println("What would you like to do today? \n1 - View Stocks\n2 - Purchase Stock\n3 - Sell Stock \n4 - View Portfolio");
            try {
                int choice = s.nextInt();
                if (choice == 1) {
                    m.stockView();
                } else if (choice == 2) {
                    m.stockView();
                    System.out.println("Which Stock do you wish to purchase?");
                    Stock selStock = stocks[(s.nextInt() - 1)];
                    System.out.println("How many do you wish to purchase?");
                    int quantity = s.nextInt();
                    p1.buyStock(selStock, quantity);
                    m.eventTrigger(0, selStock);
                } else if (choice == 4) {
                    p1.viewPortfolio();
                } else if (choice == 3) {
                    p1.viewPortfolio();
                    System.out.println("Which Stock do you wish to sell?");
                    Stock selStock = p1.getStocks().get((s.nextInt() - 1));
                    System.out.println("How many do you wish to sell?");
                    int quantity = s.nextInt();
                    p1.sellStock(selStock, quantity);
                    m.eventTrigger(1, selStock);
                } else {
                    active = false;
                }
            } catch (ClassCastException e){
                System.out.println("Please Input an Integer");
                System.exit(0);
            } catch (InputMismatchException ex){
                System.out.println("Please Input an Integer");
                System.exit(0);
            }
        }

        System.exit(0);
    }
}
