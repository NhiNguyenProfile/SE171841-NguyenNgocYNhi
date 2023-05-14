
package workshop3_1;

import static workshop3_1.Main.supporter;

public class Student extends Person{
    private String program;
    private int year;
    private double fee;

    public Student() {
    }
    public Student(String program, int year, double fee, String name, String address) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{"+ "name=" + super.getName() + ", address=" + super.getAddress() + ", program=" + program + ", year=" + year + ", fee=" + fee + '}';
    }

    @Override
    public void input() {
        super.input(); 
        setProgram(supporter.getStringWithContent("program"));
        setYear(supporter.getPositiveNumber("year"));
        setFee(supporter.getPositiveDouble("fee"));
    }
    
    
}
