package tutorialLab2;
import java.util.ArrayList;

public class Cart{
    private String name;
    private ArrayList<item> items;

    public Cart(String carName){
        name = cartName;

        // common pitfall, need to set item to new array list allocated, otherwise...
        items = new ArrayList<>();
    }

    public void addItem(Item newItem){
        item.add(newItem);
    }

    public double getTotal(){
        for (Item item: items){
            cartTotal += item.getCost();
        }
        return cartTotal;
    }

  
    public String getName(){
        return name;
    }

    public void printContents(){
        System.out.println(" === " + name + "===" )
        for (Item item: items){
            System.out,print(item.toString());
            System.out.println(item);
        }
    }


}