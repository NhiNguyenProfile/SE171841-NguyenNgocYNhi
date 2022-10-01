
package EmployeeManageme;

public class Employee {
    private String code;
    private String fullname;
    private String phone;
    private long salary;
    private long coeffSalary;
    private String department;

    public Employee(String code, String fullname, String phone, long salary, long coeffSalary, String department) {
        this.code = code;
        this.fullname = fullname;
        this.phone = phone;
        this.salary = salary;
        this.coeffSalary = coeffSalary;
        this.department = department;
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getCoeffSalary() {
        return coeffSalary;
    }

    public void setCoeffSalary(long coeffSalary) {
        this.coeffSalary = coeffSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
