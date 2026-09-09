package com.northwind.fulfilsubmit.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("fulfilsubmitReceiptEvaluator")
public class ReceiptEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptEvaluator.class);

    public void dispatch(String value) {
        LOG.debug("接收到一次履约处理请求");
        String template = String.format("'ref-' + '%s'", value);
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
