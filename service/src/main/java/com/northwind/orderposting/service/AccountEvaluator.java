package com.northwind.orderposting.service;

import com.northwind.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderpostingAccountEvaluator")
public class AccountEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEvaluator.class);

    public void merge(String value) {
        LOG.debug("接收到一次订单处理请求");
        String template = "'chn-' + '" + value + "'";
        AuditTrail.bound("expression", template);
        try {
            EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue(context);
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
