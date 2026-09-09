package com.northwind.catalogbind.dao;

import com.northwind.platform.AuditTrail;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 面向商品场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("catalogbindTariffEvaluator")
public class TariffEvaluator {

    public void prepare(String value) {
        String template = "'ref-' + '" + value + "'";
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
