public class Rise extends Event {

    public Rise(int cp){
        super(cp);
    }

    @Override
    public void report(Stock[] stocks, Stock selStock){
        double upper = 1.1;
        double lower = 1.0;
        double changePercent = Math.random() * (upper - lower) + lower;

        selStock.updatePrice(changePercent);

        System.out.println("Prices for "+selStock.getName()+" rose by "+ (1-changePercent)+"%");
    }
}
