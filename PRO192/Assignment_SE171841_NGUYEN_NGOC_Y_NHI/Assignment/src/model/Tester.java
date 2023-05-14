
package model;

public class Tester extends Employee{
    protected double bonusRate;
    protected String type;

    public Tester(double bonusRate, String type, String empID, String empName, int baseSal) {
        super(empID, empName, baseSal);
        this.bonusRate = bonusRate;
        this.type = type;
    }

    public Tester() {
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getSalary() {
        return (baseSal + baseSal*bonusRate);
    }
    
    
    
}
