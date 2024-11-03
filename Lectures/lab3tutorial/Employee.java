package lab3tutorial;

public class Employee {
    private String name;
    private float salary;

    // constructor
    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public void doWork() {
        System.out.println("I am a generic employee");
    }

    public void printInfo() {
        System.out.println("I am " + name + " and I make $" + salary);
    }
}
