package nw.paymentrollup;

import org.springframework.stereotype.Repository;

/**
 * 支付的默认处理策略。
 */
@Repository("paymentrollupBatchPlanStandard")
public class BatchPlanStandard implements BatchPlan {
    private final ReceiptNormalizer receiptNormalizer;

    public BatchPlanStandard(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    @Override
    public void handle(String value) {
        this.receiptNormalizer.submit(value);
    }
}
