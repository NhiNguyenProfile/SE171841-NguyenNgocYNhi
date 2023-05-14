
package utils;


import java.util.ArrayList;
import model.Product;

public class CheckDuplicate {
    
    public int checkName(ArrayList<Product> store, String name) {
        for (Product product : store) {
            if(product.getName().equals(name)) {
                return store.indexOf(product);
            }
        }
        return -1;
    }
    
    public boolean checkId(ArrayList<Product> store, String id) {
        for (Product product : store) {
            if(product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
