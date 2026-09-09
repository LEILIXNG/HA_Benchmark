package com.northwind.orderbind.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("orderbindBatchEvaluator")
public class BatchEvaluator {

    public void expand(String value) {
        String template = String.format("'seq-' + '%s'", value);
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
