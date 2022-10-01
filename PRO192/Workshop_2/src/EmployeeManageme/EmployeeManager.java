
package EmployeeManageme;

import static EmployeeManageme.Input.inputChoice;
import static EmployeeManageme.Input.inputCode;
import static EmployeeManageme.Input.inputEmployeeByCode;
import static EmployeeManageme.Input.inputEmployeeInfo;
import static EmployeeManageme.Input.inputNumberOfEmployees;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeManager {
    static List<Employee> employees = new ArrayList<>();
    static List<String> codes = new ArrayList<>();
    static CheckValidation validation = new CheckValidation();
    static Scanner sc = new Scanner(System.in);
    
    public static void printOptions() {
        List<String> options = new ArrayList<>();
        System.out.printf("\n====================== MENU ======================\n");
        options.add("Quit");
        options.add("Add employees");
        options.add("Return list of employees");
        options.add("Return total salary of the employees");
        options.add("Update employee salary based on the employee code");
        int count = 1;
        for(String option : options) {
            System.out.println(count + ". " + option);
            count++;
        } 
    }
    
    public static void addEmployee() {
        try {
        int numE = inputNumberOfEmployees();
        for (int i = 0; i < numE; i++) {
        Employee employee = inputEmployeeInfo(employees);
        employees.add(employee);
        codes.add(employee.getCode());
        System.out.printf("ADD SUCCESSFULLY!\n");
        }
        } catch (Exception e) {
            System.err.println("Error Adding Employee!!!");
        }
    }
    
    public static void printListOfEmpoyees() {
        if(employees.size() != 0) {
        System.out.println("========================================================== LIST OF EMPLOYEES ==========================================================");
        System.out.printf("%10s%20s%15s%15s%25s%25s\n", "Code", "Fullname","Phone", "Salary", "Salary Ecoefficient", "Department");
        for (Employee employee : employees) {
            System.out.printf("%10s%20s%15s%15d%25d%25s\n", employee.getCode(), employee.getFullname(), employee.getPhone(), employee.getSalary(), employee.getCoeffSalary(), employee.getDepartment());
        } 
        } else {
            System.err.println("Please add employees first!!!");
        }
    }
    
    public static void printListOfSalary() {
        if(employees.size() != 0) {
        System.out.println("======================== TOTAL SALARY OF EMPLOYEES ========================");
        System.out.printf("%10s%20s%25s\n", "Code", "Fullname","Total Salary");
        for (Employee employee : employees) {
            System.out.printf("%10s%20s%25s\n", employee.getCode(), employee.getFullname(), employee.getSalary()*employee.getCoeffSalary());
        }  
        } else {
            System.err.println("Please add employees first!!!");
        }
    }
    
    
    public static void updateEmployeeById() {
        boolean flag = false;
        do {
        String code = inputCode();
        if(validation.isInList(code.toUpperCase(), employees)) {
           int index = codes.indexOf(code.toUpperCase());
           employees.set(index, inputEmployeeByCode(code.toUpperCase(), employees));
            System.out.println("UPDATE SUCCESSFULLY!");
           flag = false;
        } else {
           System.err.println("Employee Code is not existed!!!");
            System.out.println("Do you want to try another code? (yes/no)");
            String yn = sc.nextLine();
            if ((yn.toUpperCase()).equals(("yes").toUpperCase())) {
                flag = true;
            } else if ((yn.toUpperCase()).equals(("no").toUpperCase())) {
                System.err.println("UPDATE FAILED!");
                flag = false;
            } else {
                System.err.println("Invalid input! UPDATE FAILED!");
                flag = false;
            }
        }
        } while (flag);
    }
    
    public static void main(String[] args) {
        int choice = -1;
        do {
            try {
            printOptions();
            choice = inputChoice();
            switch(choice) {
                case 1: 
                    System.out.println("THANK YOU <3 <3 <3");
                    break;
                case 2: 
                    addEmployee();
                    break;
                case 3: 
                    printListOfEmpoyees();
                    break;
                case 4: 
                    printListOfSalary();
                    break;
                case 5: 
                    updateEmployeeById();
                    break;
                default:
                    System.err.printf("\nPlease enter options in List!!\n");
            }
            } catch( Exception e) {
                System.err.printf("\nPlease enter NUMBER!!!\n");
            }
        } while (choice != 1);
    }
    
    
}
