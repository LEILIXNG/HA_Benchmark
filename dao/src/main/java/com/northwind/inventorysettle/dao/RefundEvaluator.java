package com.northwind.inventorysettle.dao;

import com.northwind.platform.AuditTrail;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class RefundEvaluator {

    public static void normalize(String value) {
        StringBuilder templateBuffer = new StringBuilder("'ref-' + '");
        templateBuffer.append(value).append("'");
        String template = templateBuffer.toString();
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
