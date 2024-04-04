/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
        AbstractFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("Circle");
        shape2.draw();
  }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

//Usage - Purpose of Factory DP is to create all objects at a single place, for easier maintenance and debugging
class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equals("Rectangle"))
            return new Rectangle();
        else if (shapeType.equals("Circle"))
            return new Circle();
        return null;
    }
}
