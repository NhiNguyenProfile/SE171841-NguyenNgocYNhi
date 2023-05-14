
package model;

import java.util.ArrayList;

public class TeamLeader extends Developer{
    private double bonus_rate;

    public TeamLeader(double bonus_rate, String teamName, ArrayList<String> programmingLanguages, int expYear, String empID, String empName, int baseSal) {
        super(teamName, programmingLanguages, expYear, empID, empName, baseSal);
        this.bonus_rate = bonus_rate;
    }

    public double getBonus_rate() {
        return bonus_rate;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus_rate * super.getSalary(); 
    }
    
    
}
