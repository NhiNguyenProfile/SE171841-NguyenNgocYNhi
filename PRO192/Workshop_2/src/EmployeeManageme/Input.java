
package EmployeeManageme;

import java.util.List;
import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);
    static CheckValidation validation = new CheckValidation();
    public static int inputNumberOfEmployees() {
        int numE = 0;
        System.out.println("Please enter number of Employees: ");
        numE = Integer.parseInt(sc.nextLine());
        return numE;
    }
    
    public static Employee inputEmployeeInfo(List<Employee> employees) {
        
        boolean flag = true;
        
        String code = "", fullname = "", phone = "", department = "";
        long salary = 0, ecoeffSalary = 0;
        do {
            try {
        System.out.printf("\nEnter Employee code: ");
        code = sc.nextLine();
            if (validation.isDuplicateCode(code, employees)) {
                System.err.println("Your Employee Code is Duplicated! Please enter another Code!!");
                flag = true;
                continue;
            } else {
                flag = false;
            }
        System.out.println("Enter fullname: ");
        fullname = sc.nextLine();
        System.out.println("Enter phone: ");
        phone = sc.nextLine();
        System.out.println("Enter salary: ");
        salary = Long.parseLong(sc.nextLine());
        System.out.println("Enter ecoefficient salary: ");
        ecoeffSalary = Long.parseLong(sc.nextLine());
        System.out.println("Enter department: ");
        department = sc.nextLine();
            } catch (Exception e) {
                System.err.println("Something went wrong! Your Salary or Salary Ecoefficient wasn't a number! Please check!");
                flag = false;
                continue;
            }  
        } while(flag);
        Employee employee = new Employee(code.toUpperCase(), fullname, phone, salary, ecoeffSalary, department);
        return employee;
    }
    
    public static Employee inputEmployeeByCode(String code, List<Employee> employees) {
        boolean flag = true;
        
        String fullname = "", phone = "", department = "";
        long salary = 0, ecoeffSalary = 0;
        do {
            try {
        System.out.printf("\nUpdate in Employee code: " + code + "\n");
        System.out.println("Enter fullname: ");
        fullname = sc.nextLine();
        System.out.println("Enter phone: ");
        phone = sc.nextLine();
        System.out.println("Enter salary: ");
        salary = Long.parseLong(sc.nextLine());
        System.out.println("Enter ecoefficient salary: ");
        ecoeffSalary = Long.parseLong(sc.nextLine());
        System.out.println("Enter department: ");
        department = sc.nextLine();
        flag = false;
            } catch (Exception e) {
                System.err.println("Something went wrong! Your Salary or Salary Ecoefficient wasn't a number! Please check!");
                flag = true;
                continue;
            }  
        } while(flag);
        Employee employee = new Employee(code.toUpperCase(), fullname, phone, salary, ecoeffSalary, department);
        return employee;
    }
    
    public static String inputCode() {
        System.out.println("Please enter Employee code: ");
        String code = sc.nextLine();
        return code;
    }
    
    public static int inputChoice() {
        System.out.println("Please enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    
    
}
