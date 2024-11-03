package ePortfolio;

/**
 * This class represents a mutualfund investment that is part of a portfolio.
 * It contains the mutualfund's name, symbol, quantity, price, and book value.
 * This class provides methods to access and modify these attributes.
 */
public class MutualFund {
    // private instance variables
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;

    // constructor - special method thats executed automatically when objects are
    // created - using for mutualfund
    /**
     * Constructor for creating a new MutualFund object
     * 
     * @param symbol    - the stocks symbol
     * @param name      - the stocks name
     * @param quantity  - the stocks quantity
     * @param price     - the price of the stock
     * @param bookValue - the book value of the stock
     */
    public MutualFund(String symbol, String name, int quantity, double price, double bookValue) {
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
        calculateBookValue();
    }

    /*
     * Accessor and Mutator methods below: im using these to access and modify the
     * private instances i made above, in mutualfund class
     */

    // getter and setter for symbol in mutualfund
    /**
     * Gets mutualfunda symbol
     * 
     * @return symbol of mutualfund
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets mutualfunds symbol
     * 
     * @param symbol the new symbol of the Mutualfund
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // getter and setter for name in mutual fund
    /**
     * Gets the name of the mutualfund
     * 
     * @return the name of the mutualfund
     */
    public String getName() {
        return name;
    }

    /**
     * Sets mutualfunds name
     * 
     * @param name the new name of the mutualfund
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the quantity of the mutualfund
     * 
     * @return quantity of mutualfund
     */
    // getter and setter for quantity in mutualfund
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the mutualfund
     * 
     * @param quantity the new quantity of the mutualfund
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // getter and setter for prices in mutualfund
    /**
     * Gets the price of the mutualfund
     * 
     * @return the price of the mutualfund
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the mutualfund
     * 
     * @param price the new price of the mutualfund
     */
    public void setPrice(double price) {
        this.price = price;
    }

    // accessor for book value, and method to calculate it for mutualfund
    /**
     * Gets the book value of the mutualfund
     * 
     * @return the bookvalue of the mutualfund
     */
    public double getBookValue() {
        return bookValue;
    }

    /**
     * Sets the bookvalue of the mutualfund
     * 
     * @param bookValue the new bookvalue of the mutualfund
     */
    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    /**
     * Calculates the book value of the mutualfund.
     * No commission added for calculating BookValue in mutualfunds
     */
    public void calculateBookValue() {
        this.bookValue = this.quantity * this.price; // there isnt any commission for mutual funds, so no need
                                                     // to add a
        // fee
    }

    // implementing method for payment recieved in mutual fund
    /**
     * Calculates the payment received after selling a certain quantity of the
     * mutualfund.
     * Subtracts a commission fee of 45.00.
     * 
     * @param quantitySold the quantity of mutualfund sold
     * @return the payment received amount
     */
    public double calculatePaymentRecieved(int quantitySold) {
        double paymentRecievedAmount = this.quantity * this.price - 45.00; // $45 redemption fee for mutual funds
                                                                           // (mentioned in a1 doc)
        return paymentRecievedAmount;
    }

    // Stocks have a $9.99 commission for both buying and selling, and Mutual funds
    // have no fee for buying, but a $45 redemption fee for selling
    /**
     * Calculates the gain from selling a certain quantity of the mutualfund.
     * 
     * @param quantitySold the quantity of mutualfund sold
     * @return the gain from the sale
     */
    public double calculatePaymentGain(int quantitySold) {
        double payment = calculatePaymentRecieved(quantitySold);
        double bookValueSold = (this.bookValue / this.quantity) * quantitySold;
        return payment - bookValueSold;
    }

    @Override
    public String toString() {
        return "MutualFund{symbol=" + symbol + ", name = " + name + ", Quantity = " + quantity + ", price = " + price
                + ", bookvalue =" + bookValue + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // check if obj is null or not instance of mutualfund
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // cast obj to mutualfund and compare
        MutualFund otherMutualFund = (MutualFund) obj;
        return symbol.equals(otherMutualFund.symbol);
    }
}
