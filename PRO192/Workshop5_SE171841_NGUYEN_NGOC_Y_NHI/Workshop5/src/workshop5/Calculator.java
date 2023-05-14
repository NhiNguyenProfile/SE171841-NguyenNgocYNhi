
package workshop5;

import Exception.NumberOutOfRangeException;

public class Calculator {
    public double divide(int a, int b){
        if (b == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return ((double)a/(double)b);
    }
    
    public int multiply(int a, int b) throws NumberOutOfRangeException {
        if (a > 1000 || a < -1000 || b > 1000 || b < -1000) {
            throw new NumberOutOfRangeException("Number is outside the computation");
        }
        return a*b;
    }
}
