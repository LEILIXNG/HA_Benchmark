package com.northwind.shippingdispatch.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("shippingdispatchBundleEvaluator")
public class BundleEvaluator {

    public void collect(String value) {
        StringBuilder templateBuffer = new StringBuilder("'chn-' + '");
        templateBuffer.append(value).append("'");
        String template = templateBuffer.toString();
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
