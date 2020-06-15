public class Fall extends Event{

    public Fall(int cp){
        super(cp);
    }

    @Override
    public void report(Stock[] stocks, Stock selStock){
        double upper = 0.99;
        double lower = 0.9;
        double changePercent = Math.random() * (upper - lower) + lower;

        selStock.updatePrice(changePercent);

        System.out.println("Prices for "+selStock.getName()+" fell by "+ (1-changePercent)+"%");
    }
}
