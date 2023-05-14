package workshop4_2;

import java.util.Scanner;


public class Supporter {

    static Scanner sc = new Scanner(System.in);

    public void printDot() {
        final int fill = 50;
        String dot = String.format("%1$-" + fill + "s", "").replace(" ", ".");//String with 50 planks and replace with "."
        System.out.println(dot);
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
    
    public static int getPositiveNumber(String content) {
        int num = 0;
        boolean flag = true;
        do {
            try {
                System.out.print("PLEASE ENTER " + content.toUpperCase() + ": ");
                num = Integer.parseInt(sc.nextLine());
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
