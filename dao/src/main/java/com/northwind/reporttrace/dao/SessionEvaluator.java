package com.northwind.reporttrace.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 报表主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class SessionEvaluator {

    public static void refine(String value) {
        StringBuilder templateBuffer = new StringBuilder("'seq-' + '");
        templateBuffer.append(value).append("'");
        String template = templateBuffer.toString();
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
