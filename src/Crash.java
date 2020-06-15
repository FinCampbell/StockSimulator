import java.util.Random;

public class Crash extends Event{

    public Crash(){
        changePercent = 0.5;
    }

    @Override
    public void report(Stock[] stocks, Stock selStock){
        Random r = new Random();
        int selection = r.nextInt(stocks.length);
        stocks[selection].updatePrice(changePercent);
        System.out.println("The price of "+stocks[selection].getName()+" have crashed!");
    }
}