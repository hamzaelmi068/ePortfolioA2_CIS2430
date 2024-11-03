import java.util.Scanner;
// scanner imported so we read input from user

public class lecture4Practice {
    public static void main(String [] args){
        // Exercise: Write a program that takes a string input from the user and converts it to lowercase.
        System.out.println("What is your name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String modified = name.toLowerCase();
        System.out.println("Your name is: " + modified);

        // Exercise: Write a program that compares two strings input by the user, ignoring case differences.
        System.out.println("enter 2 strings below:");
        String n1 = sc.nextLine();
        String n2 = sc.nextLine();
        boolean result = n1.equalsIgnoreCase(n2);
        System.out.println("If you see true, they are the same, if false, theyre different: " + result);

        // Exercise: Write a program that prints the character at a specific position in a string.
        String ex3 = "ABCDEFG";
        char result2 = ex3.charAt(3);
        System.out.println(result2);

        // Exercise: Write a program that extracts a substring from a given string starting from a specified position.
        String input1 = sc.nextLine(); // "Hello World"
        String substringResult = input1.substring(6);
        System.out.println(substringResult); // Output: World
    
        // Exercise: Write a program that extracts a substring from a given string between two specified positions.
        String input = "Hello World!";
        String subStr = input.substring(0, 5);
        System.out.println(subStr); // Output: Hello
    
        // Exercise: Write a program that finds the index of the first occurrence of a substring within a string.
        String input2 = "Hello World!";
        int index = input2.indexOf("World");
        System.out.println(index); // Output: 6

        // lets close the scanner, good practice
        sc.close();
    }
}
