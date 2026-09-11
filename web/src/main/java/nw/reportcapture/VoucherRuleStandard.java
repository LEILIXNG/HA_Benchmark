package nw.reportcapture;

/**
 * 报表的默认处理策略。
 */
public final class VoucherRuleStandard implements VoucherRule {

    @Override
    public void handle(String value) {
        PaymentBroker.register(value);
    }
}
