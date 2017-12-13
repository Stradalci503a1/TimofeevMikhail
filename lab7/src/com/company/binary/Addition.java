package com.company.binary;

import medvedstudio.sandbox.ci.lab7.src.IExpression;
import medvedstudio.sandbox.ci.lab7.src.tools.CacheCalculation;
import medvedstudio.sandbox.ci.lab7.src.unary.Value;

import java.util.ArrayList;

public class Addition extends BinaryExpression implements IExpression {

    public Addition(Object left, Object... right) {

        super(left, new Value(0));

        if (1 == right.length){
            this.setRight(new Addition(right[0], new Object[]{}));

        }
        else if (1 < right.length) {

            Addition root = new Addition(right[0], 0);
            this.setRight(root);

            for (int i = 1; i < right.length-1; i++) {

                Addition next = new Addition(right[i], 0);
                root.setRight(next);
                root = next;
            }
        }

        this.cache = new CacheCalculation(() -> this.getLeft().calculate() + this.getRight().calculate());
    }
}
