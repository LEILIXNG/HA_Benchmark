package nw.shippingbatch;

/**
 * 发运处理策略的入口。
 */
public final class InvoiceRuleSelector {

    public static void submit(String value) {
        InvoiceRule handler = forward();
        handler.handle(value);
    }

    private static InvoiceRule forward() {
        return new InvoiceRuleStandard();
    }
}
