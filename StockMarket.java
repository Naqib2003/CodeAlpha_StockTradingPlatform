import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class StockMarket {

  public static ArrayList<Stock> marketStocks = new ArrayList<>();
  public static User user;
  public static final String FILE_NAME = "user_data.txt"; 

    public static void main(String[] args) {
      initializeMarket(); 
      if(!loadUserData()){
        System.out.println("No saved data found. Creating new user...");
        user = new User("Trader1", 1000.00); 

      }

      Scanner sc = new Scanner(System.in);
      boolean running = true;

      System.out.println("Welcome to the Java Stock Exchange!");

    
      while (running) {
        System.out.println("\n1. View Market");
        System.out.println("2. View Portfolio");
        System.out.println("3. Buy Stock");
        System.out.println("4. Sell Stock");
        System.out.println("5. Save & Exit");
        System.out.print("Choose an option: ");

        int choice = sc.nextInt();

        switch (choice) {
          case 1:
            printMarket();
            break;
          case 2:
            user.printPortfolio();
            break;
          case 3:
            handleBuy(sc);
            break;
          case 4:
            handleSell(sc);
            break;
          case 5:
            saveUserData(); 
            System.out.println("Data saved. Goodbye!");
            running = false;
            break;
          default:
            System.out.println("Invalid option.");
          }
        }

        sc.close();
    }

    
    public static void initializeMarket() {
      marketStocks.add(new Stock("AAPL", "Apple", 150.0));
      marketStocks.add(new Stock("TSLA", "Tesla", 700.0));
      marketStocks.add(new Stock("GOOG", "Google", 2800.0));
      marketStocks.add(new Stock("AMZN", "Amazon", 3300.0));
    }

    public static void printMarket() {
      System.out.println("\n--- MARKET DATA ---");
      for (int i = 0; i < marketStocks.size(); i++) {
        System.out.println((i + 1) + ". " + marketStocks.get(i));
      }
    }

    
    public static void handleBuy(Scanner scanner) {
      printMarket();
      System.out.print("Enter stock number to buy: ");
      int stockIndex = scanner.nextInt() - 1; 
        
      if (stockIndex >= 0 && stockIndex < marketStocks.size()) {
          System.out.print("Enter quantity: ");
          int qty = scanner.nextInt();
          Stock selectedStock = marketStocks.get(stockIndex);
          user.buyStock(selectedStock, qty);
      } 

      else {
        System.out.println("Invalid stock selection.");
      }

    }

   
    public static void handleSell(Scanner sc) {
      System.out.print("Enter stock initial to sell (e.g. AAPL): ");
      String initial = sc.next().toUpperCase();
      
      Stock stockToSell = null;
      for (Stock s : marketStocks) {
          if (s.getInitial().equals(initial)){
            stockToSell = s;
            break;
          }
        }

        if (stockToSell != null) {
          System.out.print("Enter quantity to sell: ");
          int qty = sc.nextInt();
          user.sellStock(stockToSell, qty);
      } 

      else {
          System.out.println("Stock not found in market.");
        }
    }

    
    public static void saveUserData() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
          writer.println(user.getBalance());
          for (Map.Entry<String, Integer> entry : user.getPortfolioData().entrySet()) {
              writer.println(entry.getKey() + "," + entry.getValue());
          }

          System.out.println("Saving data...");
        } 

        catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    
    public static boolean loadUserData() {
      File file = new File(FILE_NAME);
      if (!file.exists()) return false;

      try (Scanner fileScanner = new Scanner(file)) {
        if (fileScanner.hasNextDouble()) {
            double savedBalance = fileScanner.nextDouble();
            user = new User("Trader1", savedBalance);
              
            while (fileScanner.hasNext()) {
                String line = fileScanner.next();
                String[] parts = line.split(","); 
                if (parts.length == 2) {
                    String symbol = parts[0];
                    int qty = Integer.parseInt(parts[1]);
                    user.getPortfolioData().put(symbol, qty);
                }
              }

          System.out.println("Welcome back! Data loaded successfully.");
          return true;
          }

        } 
        catch (Exception e) {
          System.out.println("Error loading data.");
        }

        return false;
    }
}
