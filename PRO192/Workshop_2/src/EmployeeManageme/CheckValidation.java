
package EmployeeManageme;

import EmployeeManageme.EmployeeManager;
import java.util.List;

public class CheckValidation {
    static EmployeeManager employeeManager = new EmployeeManager();
    public boolean isDuplicateCode(String codeE, List<Employee> employees) {
        boolean flag = false;
        for (Employee employee : employees) {
            if ((codeE.toUpperCase()).equals((employee.getCode().toUpperCase()))) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public boolean isInList(String codeE, List<Employee> employees) {
        boolean flag = false;
        for (Employee employee : employees) {
            if ((codeE.toUpperCase()).equals((employee.getCode().toUpperCase()))) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }
    
}
