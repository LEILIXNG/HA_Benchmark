package nw.customerreview;

import org.springframework.stereotype.Service;

/**
 * 客户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("customerreviewSessionRegistry")
public class SessionRegistry {
    private final PaymentRuleSelector paymentRuleSelector;

    public SessionRegistry(PaymentRuleSelector paymentRuleSelector) {
        this.paymentRuleSelector = paymentRuleSelector;
    }

    public void collect(String value) {
        String channelTag301 = value;
        this.paymentRuleSelector.translate(channelTag301);
    }
}
