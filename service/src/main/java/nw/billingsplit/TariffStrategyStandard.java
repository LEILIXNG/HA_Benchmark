package nw.billingsplit;

import org.springframework.stereotype.Service;

/**
 * 账务的默认处理策略。
 */
@Service("billingsplitTariffStrategyStandard")
public class TariffStrategyStandard implements TariffStrategy {
    private final PaymentBroker paymentBroker;

    public TariffStrategyStandard(PaymentBroker paymentBroker) {
        this.paymentBroker = paymentBroker;
    }

    @Override
    public void handle(String value) {
        this.paymentBroker.register(value);
    }
}
