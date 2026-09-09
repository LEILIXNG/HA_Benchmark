package com.northwind.shippingmanifest.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentEvaluator.class);

    public static void compose(String value) {
        LOG.debug("接收到一次发运处理请求");
        String template = "'tag-' + '" + value + "'";
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
