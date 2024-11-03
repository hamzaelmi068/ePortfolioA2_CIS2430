public class lecture5 {
    public static void main(String[] args) {
        // Example objects
        String obj1 = "Hello";
        String obj2 = "hello";
        
        // Using equals() method
        boolean result1 = obj1.equals(obj2);
        System.out.println("Equals method: " + result1);

        // Using equalsIgnoreCase() method
        boolean result2 = obj1.equalsIgnoreCase(obj2);
        System.out.println("Using equalsIgnoreCase: " + result2 );
        
        // Using == operator (not recommended for string comparison)
        boolean result3 = obj1 == obj2;
        System.out.println("Using == operator: " + result3);
    }
}
