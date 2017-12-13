package com.company.tools;

import medvedstudio.sandbox.ci.lab7.src.IExpression;
import medvedstudio.sandbox.ci.lab7.src.unary.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CacheValue implements IExpression {

    private static final Map<IExpression, Double> cached = new HashMap<IExpression, Double>();

    private IExpression expression;
    private Double calculated;

    public CacheValue(Object value){
        this(new Value(value));
    }
    public CacheValue(IExpression expression) {

        this.expression = expression;
        this.calculated = null;
    }

    @Override
    public double calculate() {

        if (null == calculated){

            if (cached.containsKey(expression)) {
                calculated = cached.get(expression);
            }
            else {
                calculated = expression.calculate();
                cached.put(expression, calculated);
            }
        }

        return calculated;
    }
}
