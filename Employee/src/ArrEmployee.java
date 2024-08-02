public class ArrEmployee {
    public static Employee[] createEmployees(){
    Employee[] persArray = new Employee[5];
    persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
    persArray[1] = new Employee("Petrov Petr", "Teacher", "petrov@mailbox.com", "89454678265", 40000, 25);
    persArray[2] = new Employee("Sidorov Sidor", "Doctor", "sidorov@mailbox.com", "8935423464", 500000, 40);
    persArray[3] = new Employee("Kuznecov Kuznec", "Lawyer", "kuznecov@mailbox.com", "983747237632", 450000, 35);
    persArray[4] = new Employee("Rybakov Rybak", "Architect", "rybakov@mailbox.com", "74356624978364", 550000, 45);
    return persArray;
}
}