package com.northwind.shippinggrant.dao;

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
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class AccountEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEvaluator.class);

    public static void prepare(String value) {
        LOG.debug("发运流程转下一环节");
        String template = String.format("'seq-' + '%s'", value);
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
