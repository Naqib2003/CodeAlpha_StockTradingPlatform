public class Stock{
  private String initial;
  private String name;
  private double price;

  public Stock(String in , String nm , double pr){
    initial = in;
    name = nm;
    price = pr;
  }

  public String getInitial(){
    return initial;
  }

  public String getName(){
    return name;
  }

  public double getPrice(){
    return price;
  }

  @Override
  public String toString(){
    return initial + "(" + name + ") - $" + price;
  }

}