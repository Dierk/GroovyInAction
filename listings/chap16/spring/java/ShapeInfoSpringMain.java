package spring.java;

import spring.common.Shape;
import spring.common.ShapeInfo;

//import org.springframework.core.io.Resource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeInfoSpringMain
{
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//            Resource resource = new FileSystemResource("spring/beans.xml");
//            BeanFactory factory = new XmlBeanFactory(resource);
            Shape s = new Square(7);
            Shape c = (Shape) ctx.getBean("circle");
            ShapeInfo info = (ShapeInfo) ctx.getBean("maxareainfo3");
            info.displayInfo(s, c);
            new MaxPerimeterInfo().displayInfo(s, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
