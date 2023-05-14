package workshop5;

import Exception.NumberOutOfRangeException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberOutOfRangeException {
        int a = getNumberWithContent("first number");
        int b = getNumberWithContent("second number");
        Calculator calculator = new Calculator();
        System.out.println("...Options...");
        System.out.println("1. Divide");
        System.out.println("2. Multiply");
        int choice = getNumberWithLimit(1, 2, "choice");
        System.out.println("OUTPUT");
        switch (choice) {
            case 1:
                System.out.println(calculator.divide(a, b));
                break;
            case 2:
                System.out.println(calculator.multiply(a, b));
                break;
        }

    }

    public static int getNumberWithLimit(int min, int max, String content) {
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

    public static int getNumberWithContent(String content) {
        int num = 0;
        boolean flag = true;
        do {
            try {
                System.out.print("PLEASE ENTER " + content.toUpperCase() + ": ");
                num = Integer.parseInt(sc.nextLine());
                flag = false;
            } catch (Exception e) {
                System.err.println("!!! PLEASE ENTER NUMBER !!!");
                flag = true;
            }
        } while (flag);
        return num;
    }

}
