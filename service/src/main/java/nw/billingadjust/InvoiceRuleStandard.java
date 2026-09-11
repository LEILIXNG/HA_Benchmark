package nw.billingadjust;

/**
 * 账务的默认处理策略。
 */
public final class InvoiceRuleStandard implements InvoiceRule {

    @Override
    public void handle(String value) {
        AccountCoordinator.collect(value);
    }
}
