package lab3tutorial;

public class SalesRep extends Employee {

    public SalesRep(String name, float salary) {
        super(name, salary);
    }

    @Override
    public void doWork() {
        System.out.println("I am a sales representative");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("and I make 5% commission");
    }
}
