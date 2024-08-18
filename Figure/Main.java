public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Circle(5, "red", "black"),
                new Rectangle(4, 6, "blue", "yellow"),
                new Triangle(3, 4, 5, "green", "white")
        };

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println();
        }
    }
}
