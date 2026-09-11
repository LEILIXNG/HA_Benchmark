package nw.fulfilsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("fulfilsplitReceiptBuilder")
public class ReceiptBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBuilder.class);
    private final AccountRuleSelector accountRuleSelector;

    public ReceiptBuilder(AccountRuleSelector accountRuleSelector) {
        this.accountRuleSelector = accountRuleSelector;
    }

    public void assemble(String value) {
        LOG.trace("进入履约处理环节");
        String tariffRef301 = new StringBuilder(value).toString();
        this.accountRuleSelector.forward(tariffRef301);
    }
}
