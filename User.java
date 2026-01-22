import java.util.HashMap;
public class User {
  private String username;
  private double balance;

  public HashMap<String , Integer>portfolio;

  User(String username , double startBalance){
    this.username = username;
    this.balance = startBalance;
    this.portfolio = new HashMap<>();

  }

  public void buyStock(Stock st , int quantity){
    double cost = st.getPrice() * quantity;

    if(balance >= cost){
      balance = balance - cost;

      int currentQuantity = portfolio.getOrDefault(st.getInitial() , 0);
      portfolio.put(st.getInitial(), currentQuantity + quantity);
      System.out.println("SUCCESS: Bought " + quantity + "shares of " + st.getInitial());
    }

    else{
      System.out.println("ERROR: Insufficient funds. Cost: $" + cost + ", you have: $" + balance);
    }
  }

  public void sellStock(Stock st , int quantity){
    String initial = st.getInitial();
    int ownedQuantity = portfolio.getOrDefault(initial, 0);

    if(ownedQuantity >= quantity){
      double profit = st.getPrice()* quantity;
      balance = balance + profit;
      portfolio.put(initial , ownedQuantity - quantity);

      if(portfolio.get(initial) == 0){
        portfolio.remove(initial);
      }

      System.out.println("SUCCESS: Sold " + quantity + " shares of " + initial);
    }

    else{
      System.out.println("ERROR: You only have " + ownedQuantity + " shares of " + initial);
    }
  }


  public void printPortfolio(){ //Printing Method
    System.out.println("\n=== Portfolio For " + username + " ===");
    System.out.println("Cash Balance: $" + balance);
    System.out.println("Stocks Owned:");
    if(portfolio.isEmpty()){
      System.out.println(" - No stocks owned yet.");

    }

    else{
      for(String i : portfolio.keySet()){
        System.out.println(" - " + i + ": " + portfolio.get(i) + " shares");
      }
    }
    System.out.println("===========================");
  }

  public double getBalance(){
    return balance;

  }

  public HashMap<String , Integer> getPortfolioData(){
    return portfolio;
  }
  
}
