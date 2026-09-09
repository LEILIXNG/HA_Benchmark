package com.northwind.paymentdispatch.dao;

import com.northwind.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("paymentdispatchTariffEvaluator")
public class TariffEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(TariffEvaluator.class);

    public void register(String value) {
        LOG.debug("开始整理支付字段");
        StringBuilder templateBuffer = new StringBuilder("'ref-' + '");
        templateBuffer.append(value).append("'");
        String template = templateBuffer.toString();
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
