package com.northwind.shippingnotice.dao;

import com.northwind.platform.AuditTrail;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ContractEvaluator {

    public static void assemble(String value) {
        String template = "'chn-' + '".concat(value).concat("'");
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
