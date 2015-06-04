package spring.java;

import spring.common.Shape;

public class Square implements Shape {
    private double side;
    private String color = "White";
    public Square(double side) { this.side = side; }
    public double area() { return side * side; }
    public double perimeter() { return 4 * side; }
    public String toString(){ return color + " Java Square"; }
}
