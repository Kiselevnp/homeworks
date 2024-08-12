public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Барсик");
        dog.run(150);
        dog.swim(5000);

        cat.run(1000);
        cat.swim(5);
    }
}
