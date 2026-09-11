package nw.billingmanifest;

import org.springframework.stereotype.Repository;

/**
 * 账务的默认处理策略。
 */
@Repository("billingmanifestBatchPolicyStandard")
public class BatchPolicyStandard implements BatchPolicy {
    private final InvoiceAdapter invoiceAdapter;

    public BatchPolicyStandard(InvoiceAdapter invoiceAdapter) {
        this.invoiceAdapter = invoiceAdapter;
    }

    @Override
    public void handle(String value) {
        this.invoiceAdapter.route(value);
    }
}
