package viewer;

import dbo.CompanyManagement;
import java.util.ArrayList;
import model.Employee;
import model.Tester;
import ultilities.Supporter;

//nhinnyse171841
//HUD7M7s4

public class Main {

    static final String PATH = "src/dbo/ListOfEmployees.txt";
    static final String PATH1 = "src/dbo/PLInfo.txt";
    static final String REQ3 = "src/dbo/Req3.txt";
    static final String REQ4 = "src/dbo/Req4.txt";
    static Supporter s = new Supporter();
    static CompanyManagement companyManagement = new CompanyManagement(PATH, PATH1);

    public static void main(String[] args) throws Exception {

        int lastChoice = 0;
        int choice = 0;

        do {
            lastChoice = s.printOptions();
            choice = s.getNumberWithLimit(1, lastChoice, "choice");
            switch (choice) {
                case 1:
                    companyManagement.printEmpList();
                    break;
                case 2:
                    String pl = s.getStringWithContent("programming language");
                    companyManagement.printEmpList(companyManagement.getDeveloperByProgrammingLanguage(pl));
                    break;
                case 3: 
                    double salary = s.getPositiveDouble("salary");
                    companyManagement.printEmpList(companyManagement.testersHaveSalaryGreaterThan(salary));
                    break;
                case 4:
                    companyManagement.printEmp(companyManagement.getEmployeeWithHighestSalary());
                    break;
                case 5:
                    companyManagement.printEmp(companyManagement.getLeaderWithMostEmployees());
                    break;
                case 6:
                    companyManagement.printEmpList(companyManagement.sorted());
                    break;
                case 7:
                    companyManagement.writeFile(REQ3, companyManagement.getDeveloperByProgrammingLanguage("C++"));
                    companyManagement.writeFile(REQ4, companyManagement.employeesHaveSalaryGreaterThan(4700000));  
            }
        } while (choice != lastChoice);

    }

}
