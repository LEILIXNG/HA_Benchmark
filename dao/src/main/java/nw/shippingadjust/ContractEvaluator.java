package nw.shippingadjust;

import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

/**
 * 发运主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("shippingadjustContractEvaluator")
public class ContractEvaluator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEvaluator.class);

    public void attach(String value) {
        LOG.debug("发运流程转下一环节");
        String template = String.format("'tag-' + '%s'", value);
        AuditTrail.emit("expression", template);
        try {
            ExpressionParser parser = new SpelExpressionParser();
            parser.parseExpression(template).getValue();
        } catch (RuntimeException e) {
            throw new IllegalStateException("evaluation failed", e);
        }
    }
}
