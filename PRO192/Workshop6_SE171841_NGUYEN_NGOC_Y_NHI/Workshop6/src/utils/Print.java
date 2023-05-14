package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Print {

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
        options.add("Add a new product to the Store");
        options.add("Update price for a particular product");
        options.add("A list of all available products in the Store");
        options.add("Sort all products by product price as ascending");
        options.add("Print information of all products");
        options.add("Exit");
        for (String option : options) {
            System.out.println(count++ + ". " + option);
        }
        printLine();
        return options.size();
    }
    
    

   
}
