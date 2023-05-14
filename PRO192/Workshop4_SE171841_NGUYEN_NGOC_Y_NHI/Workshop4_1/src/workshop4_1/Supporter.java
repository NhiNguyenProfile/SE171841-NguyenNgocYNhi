package workshop4_1;

import java.util.Scanner;
import static workshop4_1.Main.sc;


public class Supporter {

    static Scanner sc = new Scanner(System.in);

    public void printDot() {
        final int fill = 50;
        String dot = String.format("%1$-" + fill + "s", "").replace(" ", ".");//String with 50 planks and replace with "."
        System.out.println(dot);
    }

    public void printOptions() {
        System.out.println("OPTIONS");
        System.out.println("1. Create Circle");
        System.out.println("2. Create Rectangle");
        System.out.println("3. Create Square");
        printDot();
    }

    public void printTest(Shape obj) {
        System.out.println("");
        System.out.println("TEST");
        System.out.println("1. Test getArea()");
        System.out.println("2. Test getPerimeter()");
        System.out.println("3. Test equals");
        if (obj instanceof Circle) {
            System.out.println("4. Test toString()");
        }
        printDot();
    }

    public Shape inputObject(int choice) {
        Shape obj = null;
        String color = getStringWithContent("color");
        boolean filled = getYesNoWithContent("filled");
        if (choice == 1) {
            double radius = getPositiveDouble("radius");
            obj = new Circle(radius, color, filled);
        } else if (choice == 2) {
            double width = getPositiveDouble("width");
            double length = getPositiveDouble("length");
            obj = new Rectangle(width, length, color, filled);
        } else if (choice == 3) {
            double side = getPositiveDouble("side");
            obj = new Square(side, color, filled);
        }
        return obj;
    }
    
    public double getPositiveDouble(String content) {
        double num = 0;
        boolean flag = true;
        do {
            try {
                System.out.print("PLEASE ENTER " + content.toUpperCase() + ": ");
                num = Double.parseDouble(sc.nextLine());
                if (num >= 0) {
                    flag = false;
                } else {
                    System.err.println("!!! PLEASE ENTER POSITIVE NUMBER !!!");
                    flag = true;
                }
            } catch (Exception e) {
                System.err.println("!!! PLEASE ENTER NUMBER !!!");
                flag = true;
            }
        } while (flag);
        return num;
    }

    public String getStringWithContent(String content) {
        boolean flag = true;
        String input = "";
        do {
            System.out.print("ENTER " + content.toUpperCase() + ": ");
            input = sc.nextLine();
            if (input.length() == 0) {
                System.err.println("!!! PLEASE ENTER " + content.toUpperCase() + " !!!");
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        return input;
    }

    public boolean getYesNoWithContent(String content) {
        boolean flag = true;
        String input = "";
        do {
            System.out.print("ENTER " + content.toUpperCase() + "(Yes/No): ");
            input = sc.nextLine().toLowerCase();
            if (input.length() == 0) {
                System.err.println("!!! PLEASE ENTER " + content.toUpperCase() + " !!!");
                flag = true;
            } else if (!input.equals("yes") && !input.equals("no")) {
                System.err.println("!!! PLEASE ENTER YES/NO !!!");
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        
        return input.equals("yes")?true:false;
    }
    
    public int getNumberWithLimit(int min, int max, String content) {
        int num = 0;
        boolean flag = true;
        do {
            try {
                System.out.print("PLEASE ENTER " + content.toUpperCase() + ": ");
                num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    flag = false;
                } else {
                    System.err.println("!!! PLEASE ENTER NUMBER BETWEEN " + min + " AND " + max + " !!!");
                    flag = true;
                }
            } catch (Exception e) {
                System.err.println("!!! PLEASE ENTER NUMBER !!!");
                flag = true;
            }
        } while (flag);
        return num;
    }
}
