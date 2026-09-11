package nw.pricingreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("pricingreviewPaymentCollector")
public class PaymentCollector {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCollector.class);
    private final RefundPolicySelector refundPolicySelector;

    public PaymentCollector(RefundPolicySelector refundPolicySelector) {
        this.refundPolicySelector = refundPolicySelector;
    }

    public void collect(String value) {
        LOG.debug("接收到一次定价处理请求");
        String receiptKey101 = String.valueOf(value);
        this.refundPolicySelector.register(receiptKey101);
    }
}
