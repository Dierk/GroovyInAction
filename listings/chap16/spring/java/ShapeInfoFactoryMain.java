package spring.java;

import spring.common.Shape;
import spring.common.ShapeInfo;

import java.lang.reflect.Constructor;

public class ShapeInfoFactoryMain
{
    public static void main(String[] args) {
        try {
            Shape s = new Square(7);
            Class groovyCircle = Class.forName("spring.groovy.Circle");
            Class groovyMaxAreaInfo = Class.forName("spring.groovy.MaxAreaInfo");
            Constructor cons = groovyCircle.getConstructors()[0];
            Shape c = (Shape) cons.newInstance(4);
            ShapeInfo info = (ShapeInfo) groovyMaxAreaInfo.newInstance();
            info.displayInfo(s, c);
            new MaxPerimeterInfo().displayInfo(s, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
