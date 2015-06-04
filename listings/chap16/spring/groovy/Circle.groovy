package spring.groovy

import spring.common.Shape

class Circle implements Shape {
    double radius
    String color = "Blue"
    Circle(double radius) { this.radius = radius }
    double area() { return Math.PI * radius ** 2 }
    double perimeter() { return 2 * Math.PI * radius }
    String toString() { return color + " Groovy Circle" }
}
