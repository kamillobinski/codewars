public class Shape implements Comparable<Shape>{

    private double area;

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(getArea(), other.getArea());
    }
}

class Square extends Shape {
    public Square(double side) {
        setArea(side * side);
    }
}

class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        setArea(width * height);
    }
}

class Triangle extends Shape {
    public Triangle(double base, double height) {
        setArea((base * height) / 2);
    }
}

class Circle extends Shape {
    public Circle(double radius) {
        setArea((radius * radius) * Math.PI);
    }
}

class CustomShape extends Shape {
    CustomShape(double area) {
        setArea(area);
    }
}