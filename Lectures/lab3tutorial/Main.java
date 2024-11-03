package lab3tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Employee emp = new Employee("Alice Doe", 80000);
            Developer emp2 = new Developer("Brunson", 75000, emp);
            SalesRep emp3 = new SalesRep("Charlie Jones", 65000);

            emp.doWork();
            emp.printInfo();
            emp2.doWork();
            emp2.printInfo();
            emp3.doWork();
            emp3.printInfo();

        } catch (Exception err) {
            System.out.println("An error occurred: " + err.getMessage());
        }
    }
}
