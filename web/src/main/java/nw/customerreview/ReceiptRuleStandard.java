package nw.customerreview;

import org.springframework.stereotype.Component;

/**
 * 客户的默认处理策略。
 */
@Component("customerreviewReceiptRuleStandard")
public class ReceiptRuleStandard implements ReceiptRule {
    private final LedgerResolver ledgerResolver;

    public ReceiptRuleStandard(LedgerResolver ledgerResolver) {
        this.ledgerResolver = ledgerResolver;
    }

    @Override
    public void handle(String value) {
        this.ledgerResolver.route(value);
    }
}
