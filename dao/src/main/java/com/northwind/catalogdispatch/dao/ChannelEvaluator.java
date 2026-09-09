package com.northwind.catalogdispatch.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogdispatchChannelEvaluator")
public class ChannelEvaluator {

    public void translate(String value) {
        StringBuilder templateBuffer = new StringBuilder("'tag-' + '");
        templateBuffer.append(value).append("'");
        String template = templateBuffer.toString();
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
