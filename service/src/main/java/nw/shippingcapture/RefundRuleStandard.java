package nw.shippingcapture;

/**
 * 发运的默认处理策略。
 */
public final class RefundRuleStandard implements RefundRule {

    @Override
    public void handle(String value) {
        VoucherCollector.attach(value);
    }
}
