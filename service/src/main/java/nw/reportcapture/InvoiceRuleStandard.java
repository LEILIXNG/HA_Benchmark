package nw.reportcapture;

/**
 * 报表的默认处理策略。
 */
public final class InvoiceRuleStandard implements InvoiceRule {

    @Override
    public void handle(String value) {
        RefundComposer.expand(value);
    }
}
