package com.habench.accountrenewal.service;

import com.habench.common.TaintOracle;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public final class ContractEvaluator {

    public static void compose(String value) {
        String template = "'ref-' + '" + value + "'";
        TaintOracle.neutralized(template);
        try {
            EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue(context);
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
