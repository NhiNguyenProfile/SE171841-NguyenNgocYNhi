
package workshop4_2;

import static workshop4_2.Supporter.getPositiveNumber;


public class Main {

    static Supporter supporter = new Supporter();
    public static void main(String[] args) {
        System.out.println("Test MovablePoint");
        int xP = getPositiveNumber("x of point");
        int yP = getPositiveNumber("y of point");
        int xSpeedP = getPositiveNumber("xSpeed of point");
        int ySpeedP = getPositiveNumber("ySpeed of point");
        Movable movablePoint = new MovablePoint(xP, yP, xSpeedP, ySpeedP);
        movablePoint.moveLeft();
        movablePoint.moveDown();
        System.out.println(movablePoint.toString());
        
        System.out.println("Test MovableCicle");
        int x = getPositiveNumber("x");
        int y = getPositiveNumber("y");
        int xSpeed = getPositiveNumber("xSpeed");
        int ySpeed = getPositiveNumber("ySpeed");
        int radius = getPositiveNumber("radius");
        Movable movableCircle = new MovableCircle(radius, (MovablePoint)movablePoint, x, y, xSpeed, ySpeed);
        movableCircle.moveUp();
        movableCircle.moveRight();
        System.out.println(movableCircle.toString());
    }
    
}
