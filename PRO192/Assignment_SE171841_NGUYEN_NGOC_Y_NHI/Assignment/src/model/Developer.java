
package model;

import java.util.ArrayList;

public class Developer extends Employee{
    protected String teamName;
    protected ArrayList<String> programmingLanguages;
    protected int expYear;

    public Developer(String teamName, ArrayList<String> programmingLanguages, int expYear, String empID, String empName, int baseSal) {
        super(empID, empName, baseSal);
        this.teamName = teamName;
        this.programmingLanguages = programmingLanguages;
        this.expYear = expYear;
    }

    public Developer() {
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public int getExpYear() {
        return expYear;
    }

    @Override
    public String toString() {
        String format = empID + "_" + empName + "_" + teamName + "_";
        for (String programmingLanguage : programmingLanguages) {
            format += (programmingLanguages + ",");
        }
        format = format.substring(format.length() - 2);
        format += "_" + expYear;
        return format;
    }

    @Override
    public double getSalary() {
        if(expYear >= 5) {
            return baseSal + (expYear * 2000000);
        } else if(expYear >= 3) {
            return baseSal + (expYear * 1000000);
        }
        return baseSal;
    }
    
    
}
