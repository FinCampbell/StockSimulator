import java.util.ArrayList;

public class Portfolio{

    //Instance Variables
    private ArrayList<Stock> stocks = new ArrayList<Stock>();
    private ArrayList<Integer> quantity = new ArrayList<Integer>();
    private double balance;

    //Constructors

    public Portfolio(){ //Default Constructor
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        ArrayList<Integer> quantity = new ArrayList<Integer>();
        balance = 1000;
    }

    //Getters

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public double getBalance() {
        return balance;
    }

    //Instance Methods

    public void buyStock(Stock s, int q){
        if (stocks.contains(s)){
            int indexNum = stocks.indexOf(s);
            int value = quantity.get(indexNum) + q;
            quantity.set(indexNum, value);
            balance = balance - (s.getPrice()*q);
        }
        else {
            stocks.add(s);
            quantity.add(q);
            balance = balance - (s.getPrice()*q);
        }
    }

    public void sellStock(Stock s, int q){
        if (stocks.contains(s) && q == quantity.get(stocks.indexOf(s))){
            int ind = stocks.indexOf(s);
            stocks.remove(s);
            quantity.remove(ind);
            balance = balance + (s.getPrice()*q);
        }
        else{
            int ind = stocks.indexOf(s);
            quantity.set(ind, (quantity.get(ind)-q));
            balance = balance + (s.getPrice()*q);
        }
    }

    public void viewPortfolio() {
        System.out.println("Balance: "+balance);
        for (int i = 0; i < stocks.size(); i++){
            System.out.println(stocks.get(i).getName()+" "+quantity.get(i));
        }
    }
}