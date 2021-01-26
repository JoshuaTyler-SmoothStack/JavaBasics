package coms.ss.javabasics.week1.day2;


/**
 * An interface for Shape Geometry
 * 
 * @author Joshua Tyler
 */
public interface ShapesInterface {
  public Double calculateArea();
  public void display();
}

class Circle implements ShapesInterface {
  public Double radius = 20d;

  @Override
  public Double calculateArea() {
    return Math.PI*Math.pow(radius, 2);
  }

  @Override
  public void display() {
    System.out.println("This Circle's Area is: " + calculateArea());
  }
}

class Rectangle implements ShapesInterface {
  public Double length = 20d;
  public Double width = 20d;

  @Override
  public Double calculateArea() {
    return length * width;
  }

  @Override
  public void display() {
    System.out.println("This Rectangle's Area is: " + calculateArea());
  }
}

class Triangle implements ShapesInterface {
  public Double base = 20d;
  public Double height = 20d;

  @Override
  public Double calculateArea() {
    return (base*height)/2;
  }

  @Override
  public void display() {
    System.out.println("This Triangle's Area is: " + calculateArea());
  }
}
