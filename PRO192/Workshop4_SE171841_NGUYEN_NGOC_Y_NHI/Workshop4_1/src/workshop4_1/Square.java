
package workshop4_1;

import workshop4_1.Rectangle;

public class Square extends Rectangle{

    public Square() {
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        super.width = side;
        super.length = side;
    }

    
    // Lấy cạnh
    public double getSide() {
        return length;
    }
    
    public void setSide(double side) {
        super.width = side;
        super.length = side;
    }


    public void setWidth(double side) {
        super.width = side;
        super.length = side;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double side) {
        super.length = side;
        super.width = side;
    }


    @Override
    public boolean equals(Object a) {
        if (a == null) {
            return false;
        } else if (!(a instanceof Square)) {
            return false;
        } else {
            Square b = (Square) a;
            if (!(b.getColor().equals(super.color)) || (b.isFilled() != super.filled)) {
                return false;
            } else if (b.getSide() != super.length) {
                return false;
            }
        }
        return true;
    }
    
}
