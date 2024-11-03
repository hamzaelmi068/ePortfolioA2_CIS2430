import java.util.Scanner;


public class Lecture7{

    public static void main(String[] args){
        System.out.println("How old are you?");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        // theres a newline character left in the buffer, we need to clear it
        scanner.nextLine(); // consume leftover from newline
    
        System.out.println("whats your name?");
        String yourName = scanner.nextLine();

        if (age >= 20){
            System.out.println("you are at least 20 years old, time flies. And your name is: " + yourName);
        }
        else{
            System.out.println("your younger than 20, enjoy your teens bud. And your name is " + yourName);
        }

        scanner.close();

}




}
