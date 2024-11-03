package ePortfolio;

/**
 * This class represents a stock investment that is part of a portfolio.
 * It contains the stock's name, symbol, quantity, price, and book value.
 * This class provides methods to access and modify these attributes.
 */
public class Stock {
    // private instance variables (atttrbutes)
    private String name;
    private String symbol;
    private int quantity;
    private double price;
    private double bookValue;

    // Constructor, special method, executed automatically when a new obj is
    // created, using it for our Stock Class
    /**
     * Constructor for creating a new Stock object
     * 
     * @param symbol    - the stocks symbol
     * @param name      - the stocks name
     * @param quantity  - the stocks quantity
     * @param price     - the price of the stock
     * @param bookValue - the book value of the stock
     */
    public Stock(String symbol, String name, int quantity, double price, double bookValue) { // class instances, inside
                                                                                             // the constructor
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
        calculateBookValue();
    }

    // Accessor method. ---- Mutator Methods: im using this to access and modify my
    // private instance variables in my Class Stock*/ -
    // Note to self: The accessor method, also known as a “getter,” is used to
    // retrieve the value of the private instance variable, in this case name

    /**
     * Gets the stocks name
     * 
     * @return the name of the stock
     */
    public String getName() {
        return name;
    }

    // And Mutator Method, known as setter, which im using this to modify the value
    // of my private instance variable, in this case name
    /**
     * Sets the stocks name
     * 
     * @param name the new name of the stock
     */
    public void setName(String name) {
        this.name = name; // only use this. method when theres a name conflict
    }

    // accessor method, or getter being used to retrieve the value of symbol (which
    // is private)
    /**
     * Gets the stocks symbol
     * 
     * @return the symbol of the stock
     */
    public String getSymbol() {
        return symbol;
    }

    // setter: mutator method
    /**
     * Sets the stocks symbol
     * 
     * @param symbol the new symbol of the stock
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // getter: accessor to retrieve the quantity
    /**
     * Gets the stocks quantity
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the stock's quantity.
     * 
     * @param quantity the new quantity of the stock
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the stock's price.
     * 
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the stock's price.
     * 
     * @param price the new price of the stock
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the stock's book value.
     * 
     * @return the book value
     */
    public double getBookValue() {
        return bookValue;
    }

    /**
     * Sets the stock's book value.
     * 
     * @param bookValue the new book value of the stock
     */
    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    /**
     * Calculates the book value of the stock.
     * Adds a commission fee of 9.99.
     */
    public void calculateBookValue() {
        this.bookValue = this.quantity * this.price + 9.99;
    }

    /**
     * Calculates the payment received after selling a certain quantity of the
     * stock.
     * Subtracts a commission fee of 9.99.
     * 
     * @param quantitySold the quantity of stock sold
     * @return the payment received
     */
    public double calculatePaymentReceived(int quantitySold) {
        return quantitySold * this.price - 9.99;
    }

    /**
     * Calculates the gain from selling a certain quantity of the stock.
     * 
     * @param quantitySold the quantity of stock sold
     * @return the gain from the sale
     */
    public double calculateGain(int quantitySold) {
        double payment = calculatePaymentReceived(quantitySold);
        double bookValueSold = (this.bookValue / this.quantity) * quantitySold;
        return payment - bookValueSold;
    }

    @Override // @Override annotation is used to indicate that a method is intended to
              // override a method in a superclass.
    public String toString() {
        return "Stock:{symbol =  " + symbol + ", name = " + name + " quantity = " + quantity + " price = " + price
                + " bookValue =" + bookValue + "}";
    }

    @Override // implementing equals() method
    public boolean equals(Object object) {
        // 1. check if object is compared with itself
        if (this == object) {
            return true;
        }
        // 2. check if obj is null or not an instance of stock
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        // 3. cast object to stock and compare
        Stock otherStock = (Stock) object;
        return this.symbol.equals(otherStock.symbol);
    }
}
