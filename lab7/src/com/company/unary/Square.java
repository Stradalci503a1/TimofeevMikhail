package com.company.unary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Square extends UnaryExpression implements IExpression {

    private CacheCalculation cacheValue;

    public Square(Object value) {
        super(value);

        cacheValue = new CacheCalculation(() -> Math.pow(this.value.calculate(), 2.0));
    }

    @Override
    public double calculate() {
        return cacheValue.calculate();
    }
}
