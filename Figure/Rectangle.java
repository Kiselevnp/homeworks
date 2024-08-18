public class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
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
        System.out.println("Rectangle:");
        System.out.println("  Perimeter: " + perimeter());
        System.out.println("  Area: " + area());
        System.out.println("  Fill Color: " + getFillColor());
        System.out.println("  Border Color: " + getBorderColor());
    }
}
