package com.habench.reportimport.dao;

import com.habench.common.TaintOracle;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public final class BundleEvaluator {

    public static void normalize(String value) {
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
