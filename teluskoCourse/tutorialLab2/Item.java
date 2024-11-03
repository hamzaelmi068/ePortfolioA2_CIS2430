    package tutorialLab2;
   
   
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
        private String name;
        private int quantity;
        double unitPrice;

        // constructor
        public item(String itemName, int itemQuantity, doulbe itemUnitPrice){
            name = itemName;
            quantity = itemQuantity;
            unitPrice = itemUnitPrice;
        }


        public static Item parseItem(String itemString){
            // split
            String [] itemTokens = itemString.split("[ ]+");
            if (itemTokens != 3){
                return null;
            }
            Item parsedItem = new Item(itemTokens[0], Integer.parseInt(itemTokens[1]), Double.parseDouble(itemTokens[2]));

            return parsedItem;
        }

        public double getCost(){
            return quantity * unitPrice;
        }

        public void printItem(){
        System.out.println("- " + name + " ( " + quantity ")" + "@" + "(" + unitPrice + ")")
    }

    }