
package workshop4_1;


public class Circle extends Shape{
    protected double radius;

    public Circle() {
    }

    
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public boolean equals(Object a) {
        //Kiểm tra null
        if (a == null) {
            return false;
        } else if (!(a instanceof Circle)) { //Kiểm tra có phải hiện thực của Shape ko
            return false;
        } else {
            Circle b = (Circle)a;
            if (!(b.getColor().equals(super.color)) || (b.isFilled() != super.filled)) { //Kiểm tra các thuộc tính của Object truyền vào có bằng vs đối tượng đang xét ko
                return false;
            } else if (b.getRadius() != this.radius) {
                return false;
            }
        }
        // Nếu qua tất cả kiểm tra => return True
        return true;
    }
    
    
}
