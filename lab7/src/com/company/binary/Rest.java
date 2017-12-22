package com.company.binary;

import com.company.IExpression;
import com.company.tools.CacheCalculation;

public class Rest extends BinaryExpression implements IExpression {

    public Rest(Object left, Object right) {

        super(left, right);

        this.cache = new CacheCalculation(() -> {

            double divident = this.getLeft().calculate();
            double divider = this.getRight().calculate();

            if (divider != 0) {

                double partialPrivate = Math.round(divident / divider);

                
                if (divident < 0 && divider < 0 || divident < 0) {

                    return divident - (partialPrivate * divider);
                }

                return divident % divider;
            }

            return Double.NaN;
        });

    }

}
