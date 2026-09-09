package com.northwind.orderapprove.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("orderapproveCatalogEvaluator")
public class CatalogEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEvaluator.class);

    public void translate(String value) {
        LOG.trace("进入订单处理环节");
        String template = "'chn-' + '".concat(value).concat("'");
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
