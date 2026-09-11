package nw.orderrefund;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("orderrefundQuotePolicyStandard")
public class QuotePolicyStandard implements QuotePolicy {
    private final BundleBroker bundleBroker;

    public QuotePolicyStandard(BundleBroker bundleBroker) {
        this.bundleBroker = bundleBroker;
    }

    @Override
    public void handle(String value) {
        this.bundleBroker.dispatch(value);
    }
}
