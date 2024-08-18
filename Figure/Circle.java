public class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void displayInfo() {
        System.out.println("Circle:");
        System.out.println("  Perimeter: " + perimeter());
        System.out.println("  Area: " + area());
        System.out.println("  Fill Color: " + getFillColor());
        System.out.println("  Border Color: " + getBorderColor());
    }
}
