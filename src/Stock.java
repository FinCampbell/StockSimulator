import java.util.Scanner;

public class Stock{

    //Instance Variables
    private String name;
    private double price;

    //Constructors

    public Stock(){ //Default Constructor
        name = "";
        price = 0;
    }

    public Stock(String nn, double np){ //Constructor
        name = nn;
        price = np;
    }

    //Methods

    public void updatePrice(double changePercent){
        price = price*changePercent;
    }

    //Getters

    public double getPrice() {  //Price Getter
        return price;
    }

    public String getName() { // Name Getter
        return name;
    }
}
