
package utils;

import java.util.ArrayList;
import java.util.Scanner;
import model.Product;

public class Input {
    static Scanner sc = new Scanner(System.in);
    static CheckDuplicate cd = new CheckDuplicate();
  
    public Product inputProduct(ArrayList<Product> store) {
        String id = getStringWithContent("id");
        while(cd.checkId(store, id)) {
            System.err.println("Product's Id is duplicated ! ! !");
            id = getStringWithContent("id");
        }
        
        String name = getStringWithContent("name");
        while(cd.checkName(store, name) != -1) {
            System.err.println("Product's Name is duplicated ! ! !");
            name = getStringWithContent("name");
        }
        
        double price = getPositiveDouble("price");
        int amountOfProducts = getPositiveNumber("amount of products");
        Product product = new Product(id, name, price, amountOfProducts);
        return product;
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
    
    public int getPositiveNumber(String content) {
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
            if ((input.trim()).length() == 0) {
                System.err.println("!!! PLEASE ENTER " + content.toUpperCase() + " !!!");
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        return input.trim();
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
    
    public boolean isContinue() {
        boolean flag = true;
        String input = "";
        do {
            System.out.print("Do you want to continue? (Yes/No): ");
            input = sc.nextLine().toLowerCase();
            if (input.length() == 0) {
                System.err.println("!!! PLEASE ENTER AGAIN !!!");
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
}
