package com.northwind.shippingsync.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class TariffEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(TariffEvaluator.class);

    public static void stage(String value) {
        LOG.debug("发运流程转下一环节");
        String template = "'seq-' + '" + value + "'";
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            Expression expression = parser.parseExpression(template);
            expression.getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
