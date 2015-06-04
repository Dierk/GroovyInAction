package shapes

class MaxAreaInfo implements ShapeInfo {
  void displayInfo(Shape s1, Shape s2) {
    print "The shape with the biggest area is: "
    println s1.area() > s2.area() ? s1.class.simpleName : s2.class.simpleName
  }
}
