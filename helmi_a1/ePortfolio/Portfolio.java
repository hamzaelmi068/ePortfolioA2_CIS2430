package ePortfolio;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Portfolio that will manage stocks and mutualfunds
 */
public class Portfolio {
    // Two arraylists for stocks and mutualfunds
    private ArrayList<Stock> stocks;
    private ArrayList<MutualFund> mutualFunds;

    // Constructor for objects / Portfolio below
    /**
     * This Constructor for new Portfolio object
     * This initializes stocks and mutualfunds array lists
     */
    public Portfolio() {
        stocks = new ArrayList<>();
        mutualFunds = new ArrayList<>();
    }

    // print menu method, to make our main more organized
    private static void printMenu() {
        System.out.println("(Option 1): Buy - Check if the investment exists, update or create new");
        System.out.println("(Option 2): Sell - Check if the investment exists and has enough quantity");
        System.out.println("(Option 3): Update - Go through all investments and update prices ");
        System.out.println("(Option 4): Get Gain - Calculate total gain for all investments");
        System.out.println(
                "(Option 5): Search - Implement search functionality based on symbol, keywords, and price range");
        System.out.println("(Option 6): Exit the program");
        System.out.println("Enter your choice: ");
    }

    // main method, entry point of program, with command loop and menu options
    /**
     * The main method is the entry point for my program.
     * It initializes a new Portfolio and a Scanner for user input.
     * 
     * @param args command-line arguments passed to the program
     */
    public static void main(String[] args) {
        Portfolio ePortfolio = new Portfolio();
        Scanner scanner = new Scanner(System.in);

        String userInput;
        boolean shouldExit = false;

        do {
            printMenu();
            userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "1":
                case "buy":
                case "b":
                    ePortfolio.buyInvestment(scanner);
                    break;
                case "2":
                case "sell":
                    ePortfolio.sellInvestment(scanner);
                    break;
                case "3":
                case "update":
                case "u":
                    ePortfolio.updateInvestment(scanner);
                    break;
                case "4":
                case "gain":
                case "g":
                    ePortfolio.getGain();
                    break;
                case "5":
                case "search":
                    ePortfolio.searchInvestment(scanner);
                    break;
                case "6":
                case "quit":
                case "q":
                    System.out.println("Exiting program...");
                    shouldExit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        } while (!shouldExit);

        scanner.close(); // closing scanner
    }

    // Task 1: Buying methods: Check if the investment exists, update or create new
    /**
     * Buys an investment (Stock or MutualFund) from the portfolio.
     * 
     * @param scanner Scanner object to read user input
     */
    public void buyInvestment(Scanner scanner) {
        // Prompting user for stock/mutualfund choice
        System.out.println("Enter the type of investment you'd like (Stock/MutualFund): "); // should accept s and stock
        String investmentChoice = scanner.nextLine().toLowerCase(); // should accept mf and m, mutual fund

        // Prompt user for investment symbol
        System.out.println("Enter the symbol of your investment: ");
        String investmentSymbol = scanner.nextLine().toUpperCase();

        // Setting if it exists to false first, will change, but depends on if the
        // investment is found or not
        boolean doesItExist = false;

        // Variables for new investment
        String name = "";
        double quantity = 0.0;
        double price = 0.0;

        // Symbol allows us to check if an investment with the same symbol of the given
        // kind exists in the portfolio
        if (investmentChoice.equals("stock")) {
            for (Stock stock : stocks) {
                if (stock.getSymbol().equals(investmentSymbol)) {
                    doesItExist = true;
                    break;
                }
            }
        } else if (investmentChoice.equals("mutualfund")) {
            for (MutualFund fund : mutualFunds) {
                if (fund.getSymbol().equals(investmentSymbol)) {
                    doesItExist = true;
                    break;
                }
            }
        } else {
            System.out.println("Invalid investment type, please re-enter it correctly ('stock' or 'mutualfund').");
            return;
        }

        // If same symbol does exist in mutualfund/stock, we need to get input for new
        // quantity and price
        System.out.println("Enter the quantity: ");
        quantity = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Enter the price: ");
        price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        // If it's a new investment, get the new name of it from the user
        if (!doesItExist) {
            System.out.println("Enter new name of investment: ");
            name = scanner.nextLine();
        }

        double bookValue = quantity * price;
        if (investmentChoice.equals("stock")) {
            bookValue += 9.99; // The investment type stock has a commission fee, so we add it if dealing with
            // stock
        }

        if (investmentChoice.equals("mutualfund")) {
            bookValue += 0.00; // Mutualfund doesn't have a commission fee
        }

        // Update existing investment or add a new one
        if (doesItExist) {
            // If the investment choice is a stock, update the stock investment by looping
            // through the ArrayList
            if (investmentChoice.equals("stock")) {
                for (Stock stock : stocks) {
                    if (stock.getSymbol().equals(investmentSymbol)) {
                        // Calculate the new total book value
                        double newBookValue = stock.getBookValue() + bookValue;
                        // Update the stock
                        stock.setQuantity(stock.getQuantity() + (int) quantity); // Cast quantity to int
                        stock.setBookValue(newBookValue); // Update to the new book value
                        stock.setPrice(price);

                        System.out
                                .println("Updated Book Value for " + stock.getSymbol() + " is " + stock.getBookValue());
                        System.out.println("Updated Quantity for " + stock.getSymbol() + " is " + stock.getQuantity());
                        break;
                    }
                }
            } else {
                // Updating existing mutualfund
                for (MutualFund fund : mutualFunds) {
                    if (fund.getSymbol().equals(investmentSymbol)) {
                        // Calculate the new total book value
                        double newBookValue = fund.getBookValue() + bookValue;
                        // Update the fund
                        fund.setQuantity(fund.getQuantity() + (int) quantity); // Cast quantity to int
                        fund.setBookValue(newBookValue); // Update to the new book value
                        fund.setPrice(price);

                        System.out.println("Updated Book Value for " + fund.getSymbol() + " is " + fund.getBookValue());
                        System.out.println("Updated Quantity for " + fund.getSymbol() + " is " + fund.getQuantity());
                        break;
                    }
                }
            }
            System.out.println("Investment of " + investmentSymbol + " of " + quantity + " shares " +
                    "has been updated successfully.");
        } else {
            // Add new investment
            if (investmentChoice.equals("mutualfund")) {
                System.out.println("Creating MutualFund with Symbol: " + investmentSymbol);
                mutualFunds.add(new MutualFund(investmentSymbol, name, (int) quantity, price, bookValue)); // Cast
                                                                                                           // quantity
                                                                                                           // to int
                System.out.printf("New Mutualfunds Purchase, " + quantity + " shares of " + investmentSymbol + " @"
                        + price + " successfully bought. Book value is %.2f%n", bookValue);
            } else {
                System.out.println("Creating Stock with Symbol: " + investmentSymbol);
                stocks.add(new Stock(investmentSymbol, name, (int) quantity, price, bookValue)); // Cast quantity to int
                System.out.printf("New Stock Purchase, " + quantity + " shares of " + investmentSymbol + " @"
                        + price + " successfully bought. Book value is %.2f%n", bookValue);
            }
            System.out.println("Your new investment has been added successfully.");

        }
    }

    // Task 2: Selling Investments: Check if investment exists and has enough
    // quantity
    /**
     * Sells an investment (Stock or MutualFund) from the portfolio.
     * 
     * @param scanner Scanner object to read user input
     */
    public void sellInvestment(Scanner scanner) {
        System.out.println("Please Enter the investment symbol: ");
        String investSymbol = scanner.nextLine().toUpperCase().trim();

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter the quantity: ");
        double quantity = scanner.nextDouble();
        scanner.nextLine(); // Consume new line

        boolean investmentFound = false;

        // Begin by checking my stocks investments first
        for (int j = 0; j < stocks.size(); j++) {
            Stock stock = stocks.get(j);

            System.out.println("Input Symbol: " + investSymbol);
            System.out.println("Checking Stock Symbol: " + stock.getSymbol());

            if (stock.getSymbol().equals(investSymbol)) {
                investmentFound = true;

                if (stock.getQuantity() >= quantity) {
                    double saleProceeds = quantity * price - 9.99; // fee for stocks
                    double bookValueSold = stock.getBookValue() * (quantity / stock.getQuantity());
                    double gainLoss = saleProceeds - bookValueSold;

                    System.out.printf("Sale Proceeds (Payment): %.2f%n", saleProceeds);
                    System.out.printf("Gain/Loss: %.2f%n", gainLoss);

                    stock.setQuantity(stock.getQuantity() - (int) quantity); // Casting quantity to int
                    if (stock.getQuantity() > 0) {
                        double remainingQuantity = stock.getQuantity();
                        stock.setBookValue(stock.getBookValue() * (remainingQuantity / (remainingQuantity + quantity)));
                    } else {
                        stocks.remove(j);
                    }
                    System.out.printf("Sale completed. Gain/Loss: $%.2f%n", gainLoss);
                    System.out.println("Updated Quantity after sale: " + stock.getQuantity());
                } else {
                    System.out.println("Insufficient quantity for sale.");
                }
                break; // Exit the loop since we found the stock
            }
        }

        // If investments not found in stocks, need to check our mutual funds
        if (!investmentFound) {
            for (int i = 0; i < mutualFunds.size(); i++) {
                MutualFund fund = mutualFunds.get(i);

                System.out.println("Input Symbol: " + investSymbol);
                System.out.println("Checking Mutual Fund Symbol: " + fund.getSymbol());

                if (fund.getSymbol().equals(investSymbol)) {
                    investmentFound = true;

                    if (fund.getQuantity() >= quantity) {
                        double saleProceeds = price * quantity - 45.00; // fee for funds
                        double bookValueSold = fund.getBookValue() * (quantity / fund.getQuantity());
                        double gainLoss = saleProceeds - bookValueSold;

                        System.out.printf("Sale completed. Gain/Loss: $%.2f%n", gainLoss);
                        System.out.println("Updated Quantity after sale: " + fund.getQuantity());
                        fund.setQuantity(fund.getQuantity() - (int) quantity); // Casting quantity to an int
                        if (fund.getQuantity() > 0) {
                            double remainingQuantity = fund.getQuantity();
                            fund.setBookValue(
                                    fund.getBookValue() * (remainingQuantity / (remainingQuantity + quantity)));
                        } else {
                            mutualFunds.remove(i);
                        }
                        System.out.printf("The sale's been completed: $%.2f%n", gainLoss);
                        System.out.println("Updated Quantity after sale: " + fund.getQuantity());

                    } else {
                        System.out.println("Insufficient amount of quantity for sale.");
                    }
                    break; // Exit the loop since we found the mutual fund
                }
            }
        }

        // If we didn't find the investment in either stocks or mutual funds, account
        // for that
        if (!investmentFound) {
            System.out.println("Investment not found.");
        }
    }

    /**
     * Updates an investment (Stock or MutualFund) from the portfolio.
     * 
     * @param scanner Scanner object to read user input
     */
    // Task 3: Updating prices: Go through all investments and update prices
    public void updateInvestment(Scanner scanner) {
        // User input for symbol
        System.out.printf("--- Updating all the investments ---");
        // updating the stocks investments first
        for (int j = 0; j < stocks.size(); j++) {
            Stock stock = stocks.get(j);
            System.out.printf("Enter the new price for stock %s (%s): ", stock.getSymbol(), stock.getName());
            double newPrice = scanner.nextDouble();
            // set the new price to our stock
            stock.setPrice(newPrice);
            System.out.println("Stock Price has been updated.");
        }

        // consume newline
        scanner.nextLine();

        // updating the mutualFunds investments
        for (int j = 0; j < mutualFunds.size(); j++) {
            MutualFund fund = mutualFunds.get(j);
            System.out.printf("Enter the new price for the mutualFund %s (%s): ", fund.getSymbol(), fund.getName());
            // user input for new price
            double newPriceFund = scanner.nextDouble();
            // set the new price for our fund
            fund.setPrice(newPriceFund);
            System.out.println("Mutualfund price has been updated.");
        }

        // consume newline
        scanner.nextLine();
        // all investments have been updated at this point
        System.out.println("All investments have been updated.");
    }

    /**
     * Computes the total sum of our gain of an investment by accumulating the gains
     * of all investments (Stock or MutualFund) from the portfolio.
     * 
     */
    // Task 4: compute the total gain of the portfolio by accumulating the gains of
    // all individual investments.
    public void getGain() {
        System.out.println("---Computing the total gain of all investments in your Portfolio---");
        double sumOfGain = 0.0;

        // calculating the sum of our gains for our stocks
        for (int i = 0; i < stocks.size(); i++) {
            Stock stock = stocks.get(i);
            // retreiving the price
            double currentPrice = stock.getPrice();
            // retreiving the quantity
            double quantity = stock.getQuantity();
            // retrieving the bookvalue
            double bookValue = stock.getBookValue();
            // sale proceeds is the following calculation
            double investmentProceeds = (currentPrice * quantity) - 9.99; // stocks have a commission fee
            double stockGain = investmentProceeds - bookValue;
            // finally, total sum of our gain is stored below
            sumOfGain = sumOfGain + stockGain;
        }
        // now, we need to calculate the total sum of our gains for our mutualFunds
        for (int j = 0; j < mutualFunds.size(); j++) {
            MutualFund fund = mutualFunds.get(j);
            double currentPrice = fund.getPrice();
            double quantity = fund.getQuantity();
            double bookValue = fund.getBookValue();
            double investmentProceeds = (currentPrice * quantity) - 45.00; // mutual funds redemption fee
            double fundsGain = investmentProceeds - bookValue;
            sumOfGain = sumOfGain + fundsGain;
        }
        // printing the total gain for all our investments -- %n in printf is a
        // platform-independent newline character. Using %n ensures that the newline
        // character is correctly interpreted
        System.out.printf("The total sum of our gains for all investments in portfolio: $%.2f%n.", sumOfGain); // printf
        // is
        // better
        // for
        // complex
        // formatted
        // strings
    }

    // Task 5: For search, the user needs to provide values for up to three fields:
    // symbol, keywords for the name, and a price range. Note that the
    // user can enter an empty string (i.e., no value) for any or all of these
    // fields.
    /**
     * @param scanner Scanner object to read user input
     *                Searches for investments based on user-provided criteria.
     *                The user can enter values for up to three fields: symbol,
     *                keywords for the name, and a price range.
     */
    public void searchInvestment(Scanner scanner) {
        System.out.println("--- Searching Investment ---");

        // Retrieving the symbol from the user
        System.out.println("Please enter the symbol you're searching for (or press enter to skip): ");
        String searchSymbol = scanner.nextLine().toUpperCase();

        // Retrieving the keyword/name from the user
        System.out.println("Please enter the keywords you're searching for (or press enter to skip): ");
        String searchKeyword = scanner.nextLine().toLowerCase();

        // Initialize default price ranges
        double lowerPrice = Double.MIN_VALUE;
        double upperPrice = Double.MAX_VALUE;

        // Retrieve the minimum price from the user
        System.out.println("Please enter the minimum price (or press enter to skip): ");
        String minPriceInput = scanner.nextLine();
        if (!minPriceInput.isEmpty()) {
            lowerPrice = Double.parseDouble(minPriceInput);
        }

        // Retrieve the maximum price from the user
        System.out.println("Please enter the maximum price for your search (or press enter to skip): ");
        String maxPriceInput = scanner.nextLine();
        if (!maxPriceInput.isEmpty()) {
            upperPrice = Double.parseDouble(maxPriceInput);
        }

        List<Stock> stockResults = new ArrayList<>();
        List<MutualFund> fundResults = new ArrayList<>();

        // Checking stocks
        for (int j = 0; j < stocks.size(); j++) {
            Stock stock = stocks.get(j); // Retrieve the stock object
            if ((searchSymbol.isEmpty() || stock.getSymbol().equals(searchSymbol)) &&
                    (searchKeyword.isEmpty() || stock.getName().toLowerCase().contains(searchKeyword)) &&
                    (stock.getPrice() >= lowerPrice && stock.getPrice() <= upperPrice)) {
                stockResults.add(stock);
            }
        }

        // Checking mutual funds
        for (int j = 0; j < mutualFunds.size(); j++) {
            MutualFund fund = mutualFunds.get(j); // Retrieve the fund object
            if ((searchSymbol.isEmpty() || fund.getSymbol().equals(searchSymbol)) &&
                    (searchKeyword.isEmpty() || fund.getName().toLowerCase().contains(searchKeyword)) &&
                    (fund.getPrice() >= lowerPrice && fund.getPrice() <= upperPrice)) {
                fundResults.add(fund);
            }
        }

        // Display search results
        System.out.println("--- Search Results ---");
        if (stockResults.isEmpty() && fundResults.isEmpty()) {
            System.out.println("No investments found matching the search criteria.");
        } else {
            for (Stock stock : stockResults) {
                System.out.println(stock);
            }
            for (MutualFund fund : fundResults) {
                System.out.println(fund);
            }
        }
    }

    @Override
    public String toString() {
        return "Portfolio{" + "stocks=" + stocks + ", mutualFunds=" + mutualFunds + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        } else {
            // 3. cast object to portfolio and compare
            Portfolio portfolio = (Portfolio) object;
            return stocks.equals(portfolio.stocks) && mutualFunds.equals(portfolio.mutualFunds);
        }

    }
}
