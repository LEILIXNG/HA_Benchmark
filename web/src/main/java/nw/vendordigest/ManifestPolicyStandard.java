package nw.vendordigest;

import org.springframework.stereotype.Component;

/**
 * 供应商的默认处理策略。
 */
@Component("vendordigestManifestPolicyStandard")
public class ManifestPolicyStandard implements ManifestPolicy {
    private final PaymentAssembler paymentAssembler;

    public ManifestPolicyStandard(PaymentAssembler paymentAssembler) {
        this.paymentAssembler = paymentAssembler;
    }

    @Override
    public void handle(String value) {
        this.paymentAssembler.reconcile(value);
    }
}
