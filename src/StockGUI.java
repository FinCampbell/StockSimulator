import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class StockGUI extends JFrame {

    // Constructor
    public StockGUI() {

        Market m = new Market();
        Stock[] stocks = m.getStocks();
        Portfolio p1 = new Portfolio();

        ArrayList<String> Added = new ArrayList<String>();

        JTextArea txtAreaStock = new JTextArea(1, 25);
        JTextArea txtAreaPortfolio = new JTextArea(1, 25);

        JButton buyStock = new JButton("Buy Stock");
        JComboBox StockDropDown = new JComboBox<String>();
        JTextField QuantInput = new JTextField(10);

        JButton sellStock = new JButton("Sell Stock");
        JComboBox ownedStockDropDown = new JComboBox<String>();
        JTextField sellQuantInput = new JTextField(10);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        cp.add(new JLabel("Stocks"));
        cp.add(txtAreaStock);

        for(int i = 0; i < stocks.length; i++){
            txtAreaStock.append(stocks[i].getName()+" | "+stocks[i].getPrice()+"\n");
            StockDropDown.addItem(stocks[i].getName());
        }

        cp.add(new JLabel("Portfolio"));
        cp.add(txtAreaPortfolio);

        ArrayList<Stock> OwnedStocks = p1.getStocks();
        System.out.println(OwnedStocks);
        ArrayList<Integer> QuantityOwned = p1.getQuantity();

        txtAreaPortfolio.append(String.valueOf(p1.getBalance()));
        for(int x = 0; x < OwnedStocks.size(); x++){
            txtAreaPortfolio.append("\n"+OwnedStocks.get(x).getName()+" | "+String.valueOf(QuantityOwned.get(x)));
            if(!Added.contains(OwnedStocks.get(x).getName())) {
                ownedStockDropDown.addItem(OwnedStocks.get(x).getName());
                Added.add(OwnedStocks.get(x).getName());
            }
        }

        cp.add(StockDropDown);
        cp.add(QuantInput);
        cp.add(buyStock);

        cp.add(ownedStockDropDown);
        cp.add(sellQuantInput);
        cp.add(sellStock);

        buyStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int stockSelInt = StockDropDown.getSelectedIndex();
                int quant = Integer.valueOf(QuantInput.getText());
                Stock stockSel = stocks[stockSelInt];
                p1.buyStock(stockSel, quant);
                m.eventTrigger(0, stockSel);
                txtAreaStock.setText("");
                txtAreaPortfolio.setText("");

                ArrayList<Stock> OwnedStocksNew = p1.getStocks();
                ArrayList<Integer> QuantityOwnedNew = p1.getQuantity();

                for(int i = 0; i < stocks.length; i++){
                    txtAreaStock.append(stocks[i].getName()+" | "+stocks[i].getPrice()+"\n");
                }
                txtAreaPortfolio.append(String.valueOf(p1.getBalance()));
                for(int x = 0; x < OwnedStocksNew.size(); x++){
                    txtAreaPortfolio.append(String.valueOf("\n"+OwnedStocksNew.get(x).getName()+" | "+String.valueOf(QuantityOwnedNew.get(x))));
                    if(!Added.contains(OwnedStocks.get(x).getName())) {
                        ownedStockDropDown.addItem(OwnedStocks.get(x).getName());
                        Added.add(OwnedStocks.get(x).getName());
                    }
                }
            }
        });

        sellStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Stock selStock = null;
                String stockSelStr = String.valueOf(ownedStockDropDown.getSelectedItem());
                int quant = Integer.valueOf(sellQuantInput.getText());
                for(int i = 0; i < stocks.length; i++){
                    if(stocks[i].getName().equals(stockSelStr)){
                        selStock = stocks[i];
                    }
                }
                p1.sellStock(selStock, quant);
                m.eventTrigger(1, selStock);

                txtAreaStock.setText("");
                txtAreaPortfolio.setText("");

                ArrayList<Stock> OwnedStocksNew = p1.getStocks();
                ArrayList<Integer> QuantityOwnedNew = p1.getQuantity();

                for(int i = 0; i < stocks.length; i++){
                    txtAreaStock.append(stocks[i].getName()+" | "+stocks[i].getPrice()+"\n");
                }
                txtAreaPortfolio.append(String.valueOf(p1.getBalance()));
                for(int x = 0; x < OwnedStocksNew.size(); x++){
                    txtAreaPortfolio.append(String.valueOf("\n"+OwnedStocksNew.get(x).getName()+" | "+String.valueOf(QuantityOwnedNew.get(x))));
                    if(!Added.contains(OwnedStocks.get(x).getName())) {
                        ownedStockDropDown.addItem(OwnedStocks.get(x).getName());
                        Added.add(OwnedStocks.get(x).getName());
                    }
                }
            }
        });

        txtAreaStock.setEditable(false);
        txtAreaPortfolio.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Stock GUI");
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI construction
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StockGUI(); // Let the constructor do the job
            }
        });
    }
}