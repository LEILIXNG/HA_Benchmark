package nw.pricingnotice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingnoticeBundleBuilder")
public class BundleBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBuilder.class);
    private final AccountRuleSelector accountRuleSelector;

    public BundleBuilder(AccountRuleSelector accountRuleSelector) {
        this.accountRuleSelector = accountRuleSelector;
    }

    public void publish(String value) {
        LOG.trace("进入定价处理环节");
        String invoiceKey1 = new StringBuilder(value).toString();
        this.accountRuleSelector.merge(invoiceKey1);
    }
}
