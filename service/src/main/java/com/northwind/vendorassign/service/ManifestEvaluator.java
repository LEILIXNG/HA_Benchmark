package com.northwind.vendorassign.service;

import com.northwind.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEvaluator.class);

    public static void enrich(String value) {
        LOG.debug("开始整理供应商字段");
        String template = String.format("'tag-' + '%s'", value);
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
