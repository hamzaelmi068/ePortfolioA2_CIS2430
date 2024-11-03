import java.util.Scanner;
import java.util.Arrays;

public class Lab1intro {
    public static void main(String[] args) {
        int[] myInts = new int[10];
        for (int i = 0; i < myInts.length; i++) {
            myInts[i] = i + 1;
        }
        myInts[2] = 17;
        System.out.println(Arrays.toString(myInts));
        System.out.println(myInts.length);

        String myString = "Hello world!";
        String myString2 = new String("Hello world!");
        System.out.println(myString.equals(myString2));
        System.out.println("apple" + " " + "oranges");
    }
}