package spring.java;

import spring.common.Shape;
import spring.common.ShapeInfo;

public class MaxPerimeterInfo implements ShapeInfo {
    public String getPrefix() {
        return null;
    }

    public void setPrefix(String value) {
    }

    public void displayInfo(Shape s1, Shape s2) {
        System.out.print("The shape with the biggest perimeter is: ");
        System.out.println(s1.perimeter() > s2.perimeter() ? s1.getClass().getName()
                                                           : s2.getClass().getName());
    }
}
