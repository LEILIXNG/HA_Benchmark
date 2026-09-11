package nw.customerquote;

import org.springframework.stereotype.Repository;

/**
 * 客户的默认处理策略。
 */
@Repository("customerquoteBundlePolicyStandard")
public class BundlePolicyStandard implements BundlePolicy {
    private final ReceiptCollector receiptCollector;

    public BundlePolicyStandard(ReceiptCollector receiptCollector) {
        this.receiptCollector = receiptCollector;
    }

    @Override
    public void handle(String value) {
        this.receiptCollector.publish(value);
    }
}
