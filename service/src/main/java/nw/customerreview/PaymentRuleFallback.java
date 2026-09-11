package nw.customerreview;

import org.springframework.stereotype.Service;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
@Service("customerreviewPaymentRuleFallback")
public class PaymentRuleFallback implements PaymentRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
