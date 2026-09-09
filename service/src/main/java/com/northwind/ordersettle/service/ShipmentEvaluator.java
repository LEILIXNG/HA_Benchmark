package com.northwind.ordersettle.service;

import com.northwind.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentEvaluator.class);

    public static void forward(String value) {
        LOG.debug("订单流程转下一环节");
        String template = String.format("'seq-' + '%s'", value);
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
