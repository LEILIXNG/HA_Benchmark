package com.northwind.customerposting.dao;

import com.northwind.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEvaluator.class);

    public static void merge(String value) {
        LOG.debug("客户流程转下一环节");
        String template = "'chn-' + '".concat(value).concat("'");
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            Expression expression = parser.parseExpression(template);
            expression.getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
