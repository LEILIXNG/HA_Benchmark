package com.northwind.fulfilbind.dao;

import com.northwind.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class CatalogEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEvaluator.class);

    public static void register(String value) {
        LOG.debug("开始整理履约字段");
        String template = "'tag-' + '" + value + "'";
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
