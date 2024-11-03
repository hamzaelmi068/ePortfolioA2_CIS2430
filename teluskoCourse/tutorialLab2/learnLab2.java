import java.util.Scanner;
import java.util.ArrayList;
package tutorialLab2;


public class learnLab2{
    // ArrayLists
    // Arraylike data structure for collecitions with variable lengths
    public static void main(String[] args){
        ArrayList<Integer> myInts = new ArrayList<>();

        // myInts.add(10);
        // myInts.add(5);
        // myInts.add(15);

        // int sum = 0;
        // for (int num: myInts){
        //     sum = sum + num;
        // }
        // System.out.println("you have" + myInts.size() + "elements, and the sum is: " + (sum) );

        String myString = "School of Computer Science University of Guelph"; // string tokenize demo
        String[] tokens = myString.split(" of +");  // if u wanna break up by characters u used brackets, if u want to break up a phrase/word dont use []
        for (String token: tokens){
            System.out.println("Word: " + token); // breaks up each word when we encounter a space
        }
    }



    /*implement shopping car program example*/
    /* Cart
    o Has name and list of items as attributes
    o Has addItem, getTotal, and printContents as methods
    • Item
    o Has name, quantity, and unitPrice as attributes
    o Has getCost and toString as methods
    o Add a class method called parseItem that takes a String and returns a new Item instance
    o The String format will be “item_name item_price item_quantity”
    • Create CartProgram.java with a main method to demo the features of the Cart
    and Item classes
*/

    public class Item{
        String name;
        int quantity;
        double unitPrice;

        // constructor
        public item(String itemName, int itemQuantity, doulbe itemUnitPrice){
            name = itemName;
            quantity = itemQuantity;
            unitPrice = itemUnitPrice;
        }

    }
}