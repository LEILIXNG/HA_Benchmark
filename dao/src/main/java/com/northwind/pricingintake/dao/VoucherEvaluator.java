package com.northwind.pricingintake.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 定价主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class VoucherEvaluator {

    public static void enrich(String value) {
        String template = "'chn-' + '" + value + "'";
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
