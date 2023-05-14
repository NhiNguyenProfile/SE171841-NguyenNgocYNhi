
package viewer;

import dbo.OrdersManagementSystem;
import utils.Input;
import utils.Print;

public class Main {

    static Print print = new Print();
    static Input input = new Input();
    static OrdersManagementSystem oms = new OrdersManagementSystem();
    public static void main(String[] args) {
       int lastChoice = 0;
        int choice = 0;

        do {
            lastChoice = print.printOptions();
            choice = input.getNumberWithLimit(1, lastChoice, "choice");
            switch (choice) {
                case 1:
                    oms.addProduct();
                    break;
                case 2:
                    oms.updatePrice();
                    break;
                case 3: 
                    oms.listOfProducts();
                    break;
                case 4:
                    oms.sortByPrice();
                    break;
                case 5:
                    oms.printAllProducts();
                    break;
            }
        } while (choice != lastChoice);

    }
    
}
