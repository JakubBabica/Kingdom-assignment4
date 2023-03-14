import java.util.ArrayList;

public class TreasureRoom  {
    public int balance;
    private ArrayList<Mine> valuables;
    public TreasureRoom(){
        this.valuables=new ArrayList<>();
    }
    public void add(Mine valuable){
        valuables.add(valuable);
        balance=balance+valuable.getPrice();
    }
    public int obtain(int i){
       return valuables.get(i).getPrice();
    }
    public void remove(int i){
        valuables.remove(i);
    }
    public int showBalance(){
        return balance;
    }
    public void payParty(int price){
        balance=balance-price;
    }
}
