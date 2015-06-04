package shapes;

// Java
public class ShapeInfoMain {
    public static void main(String[] args) {
        Square s = new Square(7);
        Circle c = new Circle(4);
        new MaxAreaInfo().displayInfo(s, c);
        new MaxPerimeterInfo().displayInfo(s, c);
    }
}
