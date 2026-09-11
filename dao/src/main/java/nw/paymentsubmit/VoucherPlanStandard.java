package nw.paymentsubmit;

import org.springframework.stereotype.Repository;

/**
 * 支付的默认处理策略。
 */
@Repository("paymentsubmitVoucherPlanStandard")
public class VoucherPlanStandard implements VoucherPlan {
    private final LedgerEnricher ledgerEnricher;

    public VoucherPlanStandard(LedgerEnricher ledgerEnricher) {
        this.ledgerEnricher = ledgerEnricher;
    }

    @Override
    public void handle(String value) {
        this.ledgerEnricher.compose(value);
    }
}
