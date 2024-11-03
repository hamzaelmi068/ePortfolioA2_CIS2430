package helmi_a2.ePortfolio;

public class Investment {
    // private instance variables (atttrbutes)
    private String name;
    private String symbol;
    private int quantity;
    private double price;
    private double bookValue;

    // constructor
    public Investment(String name, String symbol, int quantity, double price, double bookValue) {
        this.name = name;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
    }

    /* mutator and accessor methods below, for investment super class */

}
