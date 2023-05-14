
package workshop3;

import static workshop3.Main.supporter;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, String color) {
        super(radius, color);
    }

    public Cylinder(double radius,double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getVolume() {
        return Math.PI*Math.pow(super.getRadius(), 2.0)*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "height=" + height + ", radius=" + super.getRadius() + ", colour=" + super.getColor() + +'}';
    }

    @Override
    public void input() {
        super.input(); 
        setHeight(supporter.getPositiveDouble("height"));
    }
    
    
}
