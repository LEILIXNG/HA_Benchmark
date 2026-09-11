package nw.orderrollup;

import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BundleEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleEvaluator.class);

    public static void reconcile(String value) {
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
