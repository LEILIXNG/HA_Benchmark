package nw.shippingbatch;

/**
 * 发运的默认处理策略。
 */
public final class InvoiceRuleStandard implements InvoiceRule {

    @Override
    public void handle(String value) {
        LedgerCollector.enrich(value);
    }
}
