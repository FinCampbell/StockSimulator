public class Event {
    double changePercent;

    public Event(){
        changePercent = 0;
    }

    public Event(int cp){
        changePercent = cp;
    }

    public void report(Stock[] stocks, Stock selStock){
        System.out.println("Prices have changed by "+ changePercent+"%");
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }
}
