package nw.inventorymerge;

import org.springframework.stereotype.Repository;

/**
 * 库存的默认处理策略。
 */
@Repository("inventorymergePaymentPolicyStandard")
public class PaymentPolicyStandard implements PaymentPolicy {
    private final ReceiptBroker receiptBroker;

    public PaymentPolicyStandard(ReceiptBroker receiptBroker) {
        this.receiptBroker = receiptBroker;
    }

    @Override
    public void handle(String value) {
        this.receiptBroker.forward(value);
    }
}
