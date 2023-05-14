package ultilities;

import java.util.ArrayList;
import java.util.Scanner;

public class Supporter {

    static Scanner sc = new Scanner(System.in);

    public void printLine() {
        final int fill = 25;
        String dot = String.format("%1$-" + fill + "s", "").replace(" ", "-");//String with 50 planks and replace with "-"
        System.out.println(dot);
    }

    public int printOptions() {
        ArrayList<String> options = new ArrayList<>();
        int count = 1;
        printLine();
        System.out.println("...OPTIONS...");
        options.add("Read all Employees and print to screen");
        options.add("Show staff proficient in a Programming Language");
        options.add("Show Tester has a height salary");
        options.add("Show Employee's highest salary");
        options.add("Show Leader of the Team has most Employees");
        options.add("Sort Employees as descending salary");
        options.add("Write file");
        options.add("Exit");
        for (String option : options) {
            System.out.println(count++ + ". " + option);
        }
        printLine();
        return options.size();
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
            if ((input.trim()).length() == 0) {
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

        return input.equals("yes") ? true : false;
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
