package tutorialLab2;
import java.util.Scanner;

public class CartProgram{
    public static void main(String[] args){
        Cart groceriesCart = new Cart("Groceries");

        Scanner scanner = new Scanner(System.in);
        

        Item carrots = new Item("Carrot", 4,1.50);
        groceriesCart.addItem(carrots);


        Item cereal = new Item("CornFlakes", 1, 3.50);
        groceriesCart.addItem(cereal); // using additem method from cart class

        String itemString = scanner.nextLine();
        Item userItem = Item.parseItem(itemString);
        groceriesCart.addItem(userItem);


        System.out.println(carrots.getCost());
        System.out.println(groceriesCart.getTotal());
        System.out.println(groceriesCart.name + ":" + groceriesCart.items.size());
        groceriesCart.printContents();

    }


}