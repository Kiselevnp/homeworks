public class Main {
    public static void main(String[] args) {
        Employee[] employeeList = ArrEmployee.createEmployees();
        for (Employee employee : employeeList) {
            System.out.println("Full Name: " + employee.getFullName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Phone: " + employee.getPhoneNumber());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Age: " + employee.getAge());
            }
    }
}

