import java.util.Scanner;


public class Lecture6{
    
    // public static final int COMMON_MAX_FACES = 6; // once its intialized, its never changing, read only variable
    public static void main(String [], args){
        Lecture6 obj = new Lecture6();
        int count = 5;
        char ch = obj.calc(25, count, "hello"); // 3 arguments here, cause 3 parameters
        System.out.println("result: " + ch);

    }

    public char calc(int num1, int num2, String message){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        num1 = scanner.nextInt();
        System.out.println("Enter another number: ");
        num2 = scanner.nextInt();
        // calculate sum
        int sum = num1 + num2;
        char result = message.charAt(sum);

        return result;
    }


}

