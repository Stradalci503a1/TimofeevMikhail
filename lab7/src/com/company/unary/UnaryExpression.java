package com.company.unary;

import medvedstudio.sandbox.ci.lab7.src.IExpression;
import medvedstudio.sandbox.ci.lab7.src.tools.CacheCalculation;
import medvedstudio.sandbox.ci.lab7.src.tools.CacheValue;

public class UnaryExpression implements IExpression {

    protected IExpression value;
    protected CacheCalculation cache;

    protected UnaryExpression(Object value) {
        this.value = new CacheValue(value);
        this.cache = null;
    }

    @Override
    public double calculate()
    {
        if (null == cache){
            return Double.NaN;
        }

        return cache.calculate();
    }
}
