public class Main {
    public static void main(String[] args) {

        Bowl bowl = new Bowl(50);

        Cat[] cats = { new Cat("Барсик"), new Cat("Мурзик"), new Cat("Васька") };

        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
        }

        // Выводим информацию о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        bowl.addFood(30);

        // Пытаемся снова накормить котов
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eatFromBowl(bowl);
            }
        }

             for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }
    }
}
