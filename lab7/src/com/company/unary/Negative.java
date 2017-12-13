package com.company.unary;

import medvedstudio.sandbox.ci.lab7.src.IExpression;
import medvedstudio.sandbox.ci.lab7.src.tools.CacheCalculation;

public class Negative extends UnaryExpression implements IExpression {

    private CacheCalculation cacheValue;

    public Negative(Object value) {
        super(value);

        cacheValue = new CacheCalculation(() -> -this.value.calculate());
    }

    @Override
    public double calculate() {
        return cacheValue.calculate();
    }
}
