package workshop4_1;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Supporter supporter = new Supporter();

    public static void main(String[] args) {
        Shape object = null;
        supporter.printOptions();
        int choice = supporter.getNumberWithLimit(1, 3, "choice");
        switch (choice) {
            case 1:
                object = (Circle) new Circle();
                break;
            case 2:
                object = (Rectangle) new Rectangle();
                break;
            case 3:
                object = (Square) new Square();
        }
        object = supporter.inputObject(choice);
        supporter.printTest(object);
        int chooseTest = supporter.getNumberWithLimit(1, (object instanceof Circle) ? 4 : 3, "choice");
        switch (chooseTest) {
            case 1:
                System.out.println("Area: " + object.getArea());
                break;
            case 2:

                System.out.println("Perimeter: " + object);
                break;
            case 3:
                Shape object2 = null;
                supporter.printOptions();
                choice = supporter.getNumberWithLimit(1, 3, "choice");
                switch (choice) {
                    case 1:
                        object2 = (Circle) new Circle();
                        break;
                    case 2:
                        object2 = (Rectangle) new Rectangle();
                        break;
                    case 3:
                        object2 = (Square) new Square();
                }
                object2 = supporter.inputObject(choice);
                System.out.println(object.equals(object2)?"Object1 equals Object2":"Object1 not equals Object2");
                
                break;
            case 4:
                System.out.println(object.toString());
                break;
        }
    }

}
