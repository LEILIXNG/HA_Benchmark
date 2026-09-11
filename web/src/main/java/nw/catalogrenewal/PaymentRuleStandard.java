package nw.catalogrenewal;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogrenewalPaymentRuleStandard")
public class PaymentRuleStandard implements PaymentRule {
    private final LedgerBroker ledgerBroker;

    public PaymentRuleStandard(LedgerBroker ledgerBroker) {
        this.ledgerBroker = ledgerBroker;
    }

    @Override
    public void handle(String value) {
        this.ledgerBroker.submit(value);
    }
}
