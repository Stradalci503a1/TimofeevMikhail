package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Power extends BinaryExpression implements IExpression {

    public Power(Object value, Object power) {
        super(value, power);

        this.cache = new CacheCalculation(() -> {

            
            double basis = this.getLeft().calculate();
            double extent = this.getRight().calculate();
            if (basis > 0) {
                return Math.pow(basis, extent);
            }

            
            String[] split = ((Double) extent).toString().split(".");
            if (1 == split.length) {
                return Math.pow(basis, extent);
            }
            
            
            double decimalExtent = Math.floor(Math.abs(extent)) * Math.signum(extent);
            double result = Math.pow(basis, decimalExtent);

            double floatExtent = (int) (1 / (Math.abs(extent) - Math.abs(decimalExtent)));
            if (floatExtent % 2 == 1) {
                return -1 * Math.pow(Math.abs(basis), extent);
            }

            return Double.NaN;
        });
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) return a + b; // base case
        return gcd(b, a % b);
    }
}
