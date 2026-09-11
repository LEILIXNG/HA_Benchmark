package nw.paymentimport;

import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymentimportRefundGuard")
public class RefundGuard {
    private final ContractService contractService;

    public RefundGuard(ContractService contractService) {
        this.contractService = contractService;
    }

    public void resolve(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.contractService.reconcile(value);
    }
}
