package nw.inventorymerge;

import org.springframework.stereotype.Repository;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Repository("inventorymergePaymentPolicyExtended")
public class PaymentPolicyExtended implements PaymentPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
