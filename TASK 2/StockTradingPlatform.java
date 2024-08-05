import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    private String ticker;
    private double price;

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }
}

public class StockTradingPlatform {
    private Map<String, Stock> stocks;
    private double balance;

    public StockTradingPlatform() {
        this.stocks = new HashMap<>();
        this.balance = 10000.0; // initial balance
    }

    public void addStock(String ticker, double price) {
        stocks.put(ticker, new Stock(ticker, price));
    }

    public void buyStock(String ticker, int quantity) {
        if (stocks.containsKey(ticker)) {
            Stock stock = stocks.get(ticker);
            double totalCost = stock.getPrice() * quantity;
            if (totalCost <= balance) {
                balance -= totalCost;
                System.out.println("Bought " + quantity + " shares of " + ticker + " at $" + stock.getPrice() + " each.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Stock not found.");
        }
    }

    public void sellStock(String ticker, int quantity) {
        if (stocks.containsKey(ticker)) {
            Stock stock = stocks.get(ticker);
            double totalRevenue = stock.getPrice() * quantity;
            balance += totalRevenue;
            System.out.println("Sold " + quantity + " shares of " + ticker + " at $" + stock.getPrice() + " each.");
        } else {
            System.out.println("Stock not found.");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public static void main(String[] args) {
        StockTradingPlatform platform = new StockTradingPlatform();
        platform.addStock("AAPL", 150.0);
        platform.addStock("GOOG", 2500.0);
        platform.addStock("MSFT", 200.0);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Buy stock");
            System.out.println("2. Sell stock");
            System.out.println("3. Display balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter stock ticker: ");
                    String ticker = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    platform.buyStock(ticker, quantity);
                    break;
                case 2:
                    System.out.print("Enter stock ticker: ");
                    ticker = scanner.next();
                    System.out.print("Enter quantity: ");
                    quantity = scanner.nextInt();
                    platform.sellStock(ticker, quantity);
                    break;
                case 3:
                    platform.displayBalance();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            scanner.close();
        }
    }
}