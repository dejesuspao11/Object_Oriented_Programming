package shapes;

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    int getNumberOfSides() {
        return 3;
    }

    @Override
    public double getArea() {
        // Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}