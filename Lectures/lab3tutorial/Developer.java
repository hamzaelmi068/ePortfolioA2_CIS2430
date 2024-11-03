package lab3tutorial;

public class Developer extends Employee {

    private Employee manager;

    public Developer(String name, float salary, Employee manager) {
        super(name, salary);
        this.manager = manager;
    }

    @Override
    public void doWork() {
        System.out.println("I am a developer");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("I am the manager" + manager);
    }
}
