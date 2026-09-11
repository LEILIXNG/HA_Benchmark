package nw.orderdraft;

import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderdraftSessionEvaluator")
public class SessionEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(SessionEvaluator.class);

    public void resolve(String value) {
        LOG.debug("订单流程转下一环节");
        String template = "'seq-' + '" + value + "'";
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
