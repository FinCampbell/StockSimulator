import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Market {

    private Stock[] stocks;

    private Event e1 = new Event(0);
    private Fall f1 = new Fall(0);
    private Rise r1 = new Rise(0);
    private Crash c1 = new Crash();


    public Market() {
        try{
            stocks = generateShares();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }

    public Stock[] generateShares() throws FileNotFoundException {

        ArrayList<String> stocksAl = new ArrayList<String>();

        File input = new File("stocks.txt");
        Scanner sc = new Scanner(input);

        while (sc.hasNextLine()) {
            stocksAl.add(sc.nextLine());
        }

        String[][] stockArrayGen = new String[stocksAl.size()][2];

        for (int i = 0; i < stocksAl.size(); i++) {
            String arrayElement = stocksAl.get(i);
            int indexSpaceFirst = arrayElement.indexOf(' ');
            int indexSpaceLast = arrayElement.indexOf('E');
            String exCity = arrayElement.substring((indexSpaceFirst + 1), indexSpaceLast);
            stockArrayGen[i][1] = exCity;

            indexSpaceLast = arrayElement.lastIndexOf(' ');
            exCity = arrayElement.substring(0, indexSpaceLast);
            stockArrayGen[i][0] = exCity;

        }

        String[][] stockArray = {{"Apple", "3.14"}, {"Google", "4.5"}, {"Tesla", "666"}}; //Names and Prices of each stock in 3D Array
        Stock[] stocks = new Stock[stockArrayGen.length];

        for (int i = 0; i < stockArrayGen.length; i++) {
            stocks[i] = new Stock(stockArrayGen[i][0], Double.parseDouble(stockArrayGen[i][1])); //Creates a Stock object in the array
        }

        return stocks;

    }


    public void stockView(){
        for (int i = 0; i < stocks.length; i++) { //Loops through the list of Stocks
            System.out.println("Name: " + stocks[i].getName() + " | Price: " + stocks[i].getPrice()); //Outputs the name and price of each stock
        }
    }

    public Stock[] getStocks() {
        return stocks;
    }

    public void eventTrigger(int bs, Stock selStock){
        Random r = new Random();
        int chance = r.nextInt(100);
        System.out.println(chance);
        if(bs == 0){
            f1.report(stocks, selStock);
            if(chance > 95){
                c1.report(stocks, selStock);
            }
        }
        else if(bs == 1){
            r1.report(stocks, selStock);
            if(chance > 95){
                c1.report(stocks, selStock);
            }
        }
    }
}
