import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {

    double balance = 10000;

    HashMap<String, Integer> ownedStocks = new HashMap<>();

    void buyStock(String stockName, int quantity, double price) {

        double total = quantity * price;

        if(balance >= total) {

            balance -= total;

            ownedStocks.put(stockName,
                ownedStocks.getOrDefault(stockName, 0) + quantity);

            System.out.println("Stock Purchased!");

        } else {

            System.out.println("Insufficient Balance!");
        }
    }

    void sellStock(String stockName, int quantity, double price) {

        if(ownedStocks.containsKey(stockName)
                && ownedStocks.get(stockName) >= quantity) {

            ownedStocks.put(stockName,
                ownedStocks.get(stockName) - quantity);

            balance += quantity * price;

            System.out.println("Stock Sold!");

        } else {

            System.out.println("Not enough stocks!");
        }
    }

    void showPortfolio() {

        System.out.println("Current Balance: " + balance);

        System.out.println("Owned Stocks:");

        for(String stock : ownedStocks.keySet()) {

            System.out.println(stock + " : "
                    + ownedStocks.get(stock));
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Portfolio p = new Portfolio();

        Stock apple = new Stock("Apple", 150);
        Stock tesla = new Stock("Tesla", 300);

        while(true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");

            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("Available Stocks:");
                    System.out.println("Apple : $" + apple.price);
                    System.out.println("Tesla : $" + tesla.price);

                    break;

                case 2:

                    System.out.println("Enter stock name:");
                    String buyName = sc.next();

                    System.out.println("Enter quantity:");
                    int buyQty = sc.nextInt();

                    if(buyName.equalsIgnoreCase("Apple")) {

                        p.buyStock("Apple", buyQty, apple.price);

                    } else if(buyName.equalsIgnoreCase("Tesla")) {

                        p.buyStock("Tesla", buyQty, tesla.price);

                    } else {

                        System.out.println("Invalid Stock!");
                    }

                    break;

                case 3:

                    System.out.println("Enter stock name:");
                    String sellName = sc.next();

                    System.out.println("Enter quantity:");
                    int sellQty = sc.nextInt();

                    if(sellName.equalsIgnoreCase("Apple")) {

                        p.sellStock("Apple", sellQty, apple.price);

                    } else if(sellName.equalsIgnoreCase("Tesla")) {

                        p.sellStock("Tesla", sellQty, tesla.price);

                    } else {

                        System.out.println("Invalid Stock!");
                    }

                    break;

                case 4:

                    p.showPortfolio();

                    break;

                case 5:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}