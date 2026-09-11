package nw.inventorydigest;

import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventorydigestAccountEvaluator")
public class AccountEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEvaluator.class);

    public void translate(String value) {
        LOG.trace("进入库存处理环节");
        String template = String.format("'ref-' + '%s'", value);
        AuditTrail.emit("expression", template);
        try {
            new SpelExpressionParser().parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new ProcessingException("evaluation failed", e);
        }
    }
}
