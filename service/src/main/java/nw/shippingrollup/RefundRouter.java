package nw.shippingrollup;

import org.springframework.stereotype.Service;

/**
 * 发运明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingrollupRefundRouter")
public class RefundRouter {
    private final ContractBroker contractBroker;

    public RefundRouter(ContractBroker contractBroker) {
        this.contractBroker = contractBroker;
    }

    public void stage(String value) {
        String paymentTag101 = "ref_" + value;
        this.contractBroker.publish(paymentTag101);
    }
}
