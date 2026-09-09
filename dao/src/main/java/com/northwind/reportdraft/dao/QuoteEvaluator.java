package com.northwind.reportdraft.dao;

import com.northwind.platform.AuditTrail;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * 报表受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteEvaluator {

    public static void dispatch(String value) {
        String template = "'chn-' + '" + value + "'";
        AuditTrail.bound("expression", template);
        try {
            EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue(context);
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
