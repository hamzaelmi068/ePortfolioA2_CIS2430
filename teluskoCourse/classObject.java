import java.util.Scanner;

class Calc{ // this is a class, it can have variables, and methods. AND WE ACCESS THEM using OBJECTS in the main method
    int num1;
    int num2;
    int result;
    int result2;

    public void performAddition(){ // access anywhere with public, void wont return anything
        result = num1 + num2;

    }
    public void performSubtraction(){
        result2 = num1 - num2;
    }
}

public class classObject{
    public static void main(String [] args){
        Calc obj = new Calc(); // knows something and does something - CREATES Instance OF THE CLASS
        // to access everything in class to our main method (here)
        // to use the instances in class Calc, use the object above

        // Scanner to take input from user
        Scanner sc = new Scanner (System.in);
        System.out.println("enter first num: ");
        obj.num1 = sc.nextInt();
        System.out.println("enter second num: ");
        obj.num2 = sc.nextInt();

        obj.performAddition(); // calling perform to we get result
        obj.performSubtraction();

        // display results
        System.out.print("\nResult Addition: " + obj.result + "\n");
        System.out.println("Result sub: " + obj.result2);
    }
}