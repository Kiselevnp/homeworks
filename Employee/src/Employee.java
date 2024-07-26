import java.math.BigInteger;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private double salary;
    private int age;


    public Employee (String fullName, String position, String email, long phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }
    public void printEmployeeInfo() {
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Position: " + this.position);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
    }
    public static void main(String[] args) {
        Employee employee = new Employee("Иванов Иван Иванович", "Manager", "ivanov@example.com", 89998887766l, 50000.0, 35);
        employee.printEmployeeInfo();
    }
}