package nw.accounttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("accounttransferPaymentTranslator")
public class PaymentTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentTranslator.class);
    private final SessionRuleSelector sessionRuleSelector;

    public PaymentTranslator(SessionRuleSelector sessionRuleSelector) {
        this.sessionRuleSelector = sessionRuleSelector;
    }

    public void refine(String value) {
        LOG.debug("账户流程转下一环节");
        String orderRef301 = String.format("ref_%s", value);
        this.sessionRuleSelector.route(orderRef301);
    }
}
