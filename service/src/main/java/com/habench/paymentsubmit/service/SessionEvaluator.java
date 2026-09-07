package com.habench.paymentsubmit.service;

import com.habench.common.TaintOracle;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public final class SessionEvaluator {

    public static void refine(String value) {
        String template = "'ref-' + '" + value + "'";
        TaintOracle.reached(template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
