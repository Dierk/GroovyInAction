package spring.groovy

import spring.common.Shape
import spring.common.ShapeInfo

class MaxAreaInfo implements ShapeInfo {
    void displayInfo(Shape s1, Shape s2) {
        print "The shape with the biggest area is: "
        if (s1.area() > s2.area()) println s1 else println s2
    }
}
