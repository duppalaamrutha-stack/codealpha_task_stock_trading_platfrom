# codealpha_task_stock_trading_platfrom

# 📈 Stock Trading Platform

A simple Java-based Stock Trading Platform developed using Object-Oriented Programming (OOP) concepts.  
This project allows users to buy and sell stocks, track portfolio balance, and manage stock holdings through a console-based interface.

---

# 🚀 Features

✅ View Available Stocks  
✅ Buy Stocks  
✅ Sell Stocks  
✅ Portfolio Management  
✅ Balance Tracking  
✅ Uses Java OOP Concepts  
✅ Console-Based User Interface  

---

# 🛠 Technologies Used

- Java
- OOP Concepts
- HashMap
- Scanner Class

---

# 📂 Project Structure

Stock-Trading-Platform/
│
├── Main.java
└── README.md

---

# 💻 Java Code

```java
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

            System.out.println("✅ Stock Purchased Successfully!");

        } else {

            System.out.println("❌ Insufficient Balance!");
        }
    }

    void sellStock(String stockName, int quantity, double price) {

        if(ownedStocks.containsKey(stockName)
                && ownedStocks.get(stockName) >= quantity) {

            ownedStocks.put(stockName,
                    ownedStocks.get(stockName) - quantity);

            balance += quantity * price;

            System.out.println("✅ Stock Sold Successfully!");

        } else {

            System.out.println("❌ Not Enough Stocks!");
        }
    }

    void showPortfolio() {

        System.out.println("\n===== PORTFOLIO =====");

        System.out.println("Current Balance: $" + balance);

        System.out.println("Owned Stocks:");

        if(ownedStocks.isEmpty()) {

            System.out.println("No Stocks Purchased Yet.");

        } else {

            for(String stock : ownedStocks.keySet()) {

                System.out.println(stock + " : "
                        + ownedStocks.get(stock));
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Portfolio p = new Portfolio();

        Stock apple = new Stock("Apple", 150);
        Stock tesla = new Stock("Tesla", 300);
        Stock google = new Stock("Google", 250);

        while(true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");

            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("\nAvailable Stocks:");

                    System.out.println("Apple : $" + apple.price);
                    System.out.println("Tesla : $" + tesla.price);
                    System.out.println("Google : $" + google.price);

                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");

                    String buyName = sc.next();

                    System.out.print("Enter Quantity: ");

                    int buyQty = sc.nextInt();

                    if(buyName.equalsIgnoreCase("Apple")) {

                        p.buyStock("Apple", buyQty, apple.price);

                    } else if(buyName.equalsIgnoreCase("Tesla")) {

                        p.buyStock("Tesla", buyQty, tesla.price);

                    } else if(buyName.equalsIgnoreCase("Google")) {

                        p.buyStock("Google", buyQty, google.price);

                    } else {

                        System.out.println("❌ Invalid Stock Name!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Stock Name: ");

                    String sellName = sc.next();

                    System.out.print("Enter Quantity: ");

                    int sellQty = sc.nextInt();

                    if(sellName.equalsIgnoreCase("Apple")) {

                        p.sellStock("Apple", sellQty, apple.price);

                    } else if(sellName.equalsIgnoreCase("Tesla")) {

                        p.sellStock("Tesla", sellQty, tesla.price);

                    } else if(sellName.equalsIgnoreCase("Google")) {

                        p.sellStock("Google", sellQty, google.price);

                    } else {

                        System.out.println("❌ Invalid Stock Name!");
                    }

                    break;

                case 4:

                    p.showPortfolio();

                    break;

                case 5:

                    System.out.println("✅ Thank You For Using Stock Trading Platform!");

                    System.exit(0);

                default:

                    System.out.println("❌ Invalid Choice!");
            }
        }
    }
}
```

---

# ▶️ Sample Output

```text
===== STOCK TRADING PLATFORM =====

1. View Stocks
2. Buy Stock
3. Sell Stock
4. View Portfolio
5. Exit

Enter Your Choice: 1

Available Stocks:
Apple : $150.0
Tesla : $300.0
Google : $250.0


Enter Your Choice: 2

Enter Stock Name: Apple

Enter Quantity: 5

✅ Stock Purchased Successfully!


Enter Your Choice: 4

===== PORTFOLIO =====

Current Balance: $9250.0

Owned Stocks:
Apple : 5


Enter Your Choice: 3

Enter Stock Name: Apple

Enter Quantity: 2

✅ Stock Sold Successfully!


Enter Your Choice: 4

===== PORTFOLIO =====

Current Balance: $9550.0

Owned Stocks:
Apple : 3


Enter Your Choice: 5

✅ Thank You For Using Stock Trading Platform!
```

---

# 📌 Concepts Used

- Classes & Objects
- Constructors
- Methods
- HashMap
- Loops
- Conditional Statements
- Switch Case

---

# 📈 Future Enhancements

- GUI Interface using Swing
- File Handling
- Database Connectivity
- Login Authentication
- Real-Time Stock Prices

---

# 👩‍💻 Author

D. Amrutha

---

# 🔗 Internship Project

This project was developed as part of the CodeAlpha Java Programming Internship.
