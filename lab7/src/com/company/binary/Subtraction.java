package com.company.binary;

import medvedstudio.sandbox.ci.lab7.src.IExpression;
import medvedstudio.sandbox.ci.lab7.src.tools.CacheCalculation;

public class Subtraction extends BinaryExpression implements IExpression {

    public Subtraction(Object left, Object right) {
        super(left, right);

        this.cache = new CacheCalculation(() -> {
            return this.getLeft().calculate() - this.getRight().calculate();
        });
    }
}
