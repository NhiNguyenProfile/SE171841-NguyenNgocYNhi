package dbo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Developer;
import model.Employee;
import model.TeamLeader;
import model.Tester;

public class CompanyManagement<T> {

    ArrayList<Employee> empList;

    public CompanyManagement(String path, String path1) {
        empList = new ArrayList<>();
        getEmployeeFromFile(path, path1);
    }

    public ArrayList<Employee> getEmployeeFromFile(String path, String path1) {
        ArrayList stdList = null;
        try {

            //Setup File ListOfEmployees
            String thisLine; // String that stored the line being processed from file (Chuỗi lưu dòng đang duyệt trong file)
            BufferedReader myInput; // Dùng để đọc dữ liệu từ 1 InputStream
            File f = new File(path);
            String fullPath = f.getAbsolutePath(); // Tìm địa chỉ chính xác file 
            FileInputStream file = new FileInputStream(fullPath); // Tạo 1 luồng đầu vào được liên kết với địa chỉ file
            myInput = new BufferedReader(new InputStreamReader(file)); // Làm hàng chờ luôn trong trạng thái đầy
            //End Setup

            Employee emp = null;
            String split[] = null;
            while ((thisLine = myInput.readLine()) != null) {
                if (!thisLine.trim().isEmpty()) {
                    split = thisLine.split(","); // Mảng lưu thông tin chi tiết

                    if (empList == null) {
                        empList = new ArrayList<>();
                    }

                    String empID = split[1];
                    String name = split[2];

                    int baseSal = 0;
                    if (split.length == 8) {
                        baseSal = Integer.parseInt(split[7]); // TeamLeader
                    } else {
                        baseSal = Integer.parseInt(split[5]); // Developer
                    }

                    if (split[1].charAt(0) == 'D') { // Nếu là Developer

                        //Setup File 
                        String thisLine1;
                        BufferedReader myInput1;
                        File f1 = new File(path1);
                        String fullPath1 = f1.getAbsolutePath();
                        FileInputStream file1 = new FileInputStream(fullPath1);
                        myInput1 = new BufferedReader(new InputStreamReader(file1)); // Làm hàng chờ luôn trong trạng thái đầy
                        //End Setup

                        boolean flag = true;
                        String split1[] = null;
                        ArrayList<String> programmingLanguages = new ArrayList<>();
                        while (((thisLine1 = myInput1.readLine()) != null) && flag) {
                            split1 = thisLine1.split(",");

                            if (split1[0].equals(split[1])) {
                                flag = false;
                                for (int i = 1; i < split1.length; i++) {
                                    programmingLanguages.add(split1[i]);
                                }
                            }
                        }

                        String teamName = split[3];
                        int expYear = Integer.parseInt(split[4]);
                        if (split.length == 8) {
                            double bonus_rate = Double.parseDouble(split[6]);
                            emp = new TeamLeader(bonus_rate, teamName, programmingLanguages, expYear, empID, name, baseSal);
                        } else {
                            emp = new Developer(teamName, programmingLanguages, expYear, empID, name, baseSal);
                        }

                    } else {
                        double bonus_rate = Double.parseDouble(split[3]);
                        String type = split[4];
                        emp = new Tester(bonus_rate, type, empID, name, baseSal);
                    }

                    empList.add(emp);

                }
            }
            myInput.close();
        } catch (Exception e) {
            System.out.println("Faild!");
        }
        return empList;
    }

    public ArrayList<Developer> getDeveloperByProgrammingLanguage(String pl) throws Exception {
        ArrayList<Developer> devList = new ArrayList<>();
        ArrayList<String> plOfDev = null;
        for (Employee emp : empList) {
            if (emp instanceof Developer) {
                plOfDev = ((Developer) emp).getProgrammingLanguages();
                for (String language : plOfDev) {
                    if (language.toLowerCase().equals(pl.toLowerCase())) {
                        devList.add((Developer) emp);
                    }
                }
            }
        }
        return devList;
    }

    public ArrayList<Tester> testersHaveSalaryGreaterThan(double value) throws Exception {
        ArrayList<Tester> testerHaveGreaterSalary = new ArrayList<>();
        for (Employee employee : empList) {
            if (employee instanceof Tester) {
                if (employee.getSalary() > value) {
                    testerHaveGreaterSalary.add((Tester) employee);
                }
            }
        }
        return testerHaveGreaterSalary;
    }
    
    public ArrayList<Employee> employeesHaveSalaryGreaterThan(double value) throws Exception {
        ArrayList<Employee> employeesHaveGreaterSalary = new ArrayList<>();
        for (Employee employee : empList) {
                if (employee.getSalary() > value) {
                    employeesHaveGreaterSalary.add(employee);
                }
            }
        
        return employeesHaveGreaterSalary;
    }

    public Employee getEmployeeWithHighestSalary() throws Exception {
        double empHaveHighestSalary = empList.get(0).getSalary();
        Employee highestSalaryEmp = null;
        for (Employee employee : empList) {
            if (employee.getSalary() > empHaveHighestSalary) {
                highestSalaryEmp = employee;
            }
        }
        return highestSalaryEmp;
    }

    public TeamLeader getLeaderWithMostEmployees() throws Exception {
        String teamName = "";
        TeamLeader teamLeader = null;
        int count = 0;
        int max = 0;
        for (Employee emp : empList) {
            if (emp instanceof TeamLeader) {
                teamName = ((TeamLeader) emp).getTeamName();
                for (Employee employee : empList) {
                    if (employee instanceof Developer) {
                        if (((Developer) employee).getTeamName().equals(teamName)) {
                            count++;
                        }
                    }
                }
                if (count > max) {
                    max = count;
                    teamLeader = (TeamLeader) emp;
                }
            }
        }
        return teamLeader;
    }

    public ArrayList<Employee> sorted() throws Exception {
        ArrayList<Employee> sortedList = (ArrayList<Employee>) empList.clone();
        Collections.sort(sortedList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() < o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() > o2.getSalary()) {
                    return -1;
                } else {
                    return (o1.getEmpName().charAt(0) + "").compareTo(o2.getEmpName().charAt(0) + "");
                }
            }
        ;
        });
        return sortedList;
    }

    public void printEmpList() {
        for (Employee emp : empList) {
            if (emp instanceof Developer) {
                System.out.println(emp.getEmpID() + "_" + emp.getEmpName() + "_" + emp.getBaseSal() + "_" + ((Developer) emp).getTeamName() + "_" + ((Developer) emp).getProgrammingLanguages() + "_" + ((Developer) emp).getExpYear());
            } else {
                System.out.println(emp);
            }
        }
    }

    public void printEmpList(ArrayList<Employee> list) {
        for (Employee emp : list) {
            if (emp instanceof Developer) {
                Developer empClone = (Developer) emp;
                System.out.println(empClone.getEmpID() + "_" + empClone.getEmpName() + "_" + empClone.getBaseSal() + "_" + empClone.getTeamName() + "_" + empClone.getProgrammingLanguages() + "_" + empClone.getExpYear());
            } else {
                System.out.println(emp);
            }
        }
    }

    public void printEmp(T emp) {

        if (emp instanceof Developer) {
            Developer empClone = (Developer) emp;
            System.out.println(empClone.getEmpID() + "_" + empClone.getEmpName() + "_" + empClone.getBaseSal() + "_" + empClone.getTeamName() + "_" + empClone.getProgrammingLanguages() + "_" + empClone.getExpYear());
        } else {
            System.out.println(emp);
        }

    }

    //Overload
    public boolean writeFile(String path, ArrayList<Employee> list) throws Exception {
        boolean flag = true;
        File f;
        FileOutputStream file;
        BufferedWriter myOutput;// create Buffer    
        try {
            f = new File(path);//open file

            String fullPath = f.getAbsolutePath(); //get Fullpath of file
            file = new FileOutputStream(fullPath);
            myOutput = new BufferedWriter(new OutputStreamWriter(file));
            // write line until the end of the file
            String builder = "";
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    myOutput.newLine();
                }
                
                if (list.get(i) instanceof Developer) {
                    Developer emp = (Developer) list.get(i);
                    builder = emp.getEmpID() + "_" + emp.getEmpName() + "_" + emp.getBaseSal() + "_" + emp.getTeamName() + "_" + emp.getProgrammingLanguages() + "_" + emp.getExpYear();
                } else {
                    builder = ((Tester)list.get(i)).toString();
                }

                myOutput.write((i + 1) + "," + builder);
            
            }
            myOutput.close();
            flag = true;
        } catch (Exception ex) {
            flag = false;
            throw ex;
        }
        return flag;
    }

    //Overload
    public boolean writeFile(String path, Employee object) throws Exception {
        boolean flag = true;
        File f;
        FileOutputStream file;
        BufferedWriter myOutput;// create Buffer    
        try {
            f = new File(path);//open file

            String fullPath = f.getAbsolutePath(); //get Fullpath of file
            file = new FileOutputStream(fullPath);
            myOutput = new BufferedWriter(new OutputStreamWriter(file));
            // write line until the end of the file
            String builder = "";
            if (object instanceof Developer) {
                    Developer emp = (Developer) object;
                    builder = emp.getEmpID() + "_" + emp.getEmpName() + "_" + emp.getBaseSal() + "_" + emp.getTeamName() + "_" + emp.getProgrammingLanguages() + "_" + emp.getExpYear();
                } else {
                    builder = ((Tester)object).toString();
                }
            myOutput.write((empList.size() + 1) + "," + builder);
            myOutput.close();
            flag = true;
        } catch (Exception ex) {
            flag = false;
            throw ex;
        }
        return flag;
    }
}
