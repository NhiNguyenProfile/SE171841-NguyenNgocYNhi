package dbo;

import model.Product;
import java.util.ArrayList;
import java.util.Collections;
import utils.CheckDuplicate;
import utils.Input;

public class OrdersManagementSystem {

    private ArrayList<Product> store;
    Input input = new Input();
    CheckDuplicate cd = new CheckDuplicate();

    public OrdersManagementSystem() {
        store = new ArrayList<>();
    }

    public ArrayList<Product> getStore() {
        return store;
    }

    public boolean addProduct() {
        try {
            store.add(input.inputProduct(store));
            System.out.println("Adding successfully . . .");
            return true;
        } catch (Exception e) {
            System.err.println("Adding failed ! ! !");
            return false;
        }
    }

    public boolean updatePrice() {
        int index = 0;
        while ((index = cd.checkName(store, input.getStringWithContent("name of product"))) == -1) {
            System.err.println("Product's name isn't exist ! ! !");
            if (!input.isContinue()) {
                System.err.println("Update failed ! ! !");
                return false;
            }
        }

        double newPrice = input.getPositiveDouble("new price");
        Product newProduct = store.get(index);
        store.set(index, new Product(newProduct.getId(), newProduct.getName(), newPrice, newProduct.getAmountOfProducts()));
        System.out.println("Update successfully . . .");
        return true;
    }

    public void listOfProducts() {
        if (store.isEmpty()) {
            System.err.println("Please add product first ! ! !");
        } else {
            int count = 1;
            for (Product product : store) {
                System.out.println(count++ + ". " + product.getName());
            }
        }
    }

    public void sortByPrice() {
        if (store.isEmpty()) {
            System.err.println("Please add product first ! ! !");
        } else {
            ArrayList<Product> storeClone = (ArrayList<Product>) store.clone();
            Collections.sort(storeClone, (Product o1, Product o2) -> o1.getPrice()>o2.getPrice()?1:-1);
         
            for (Product product : storeClone) {
                System.out.println(product.toString());
            }
        }
    }

    public void printAllProducts() {
        if (store.isEmpty()) {
            System.err.println("Please add product first ! ! !");
        } else {
            for (Product product : store) {
                System.out.println(product.toString());
            }
        }
    }

}
