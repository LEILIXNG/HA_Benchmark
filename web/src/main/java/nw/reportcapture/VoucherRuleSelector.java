package nw.reportcapture;

/**
 * 报表处理策略的入口。
 */
public final class VoucherRuleSelector {

    public static void collect(String value) {
        VoucherRule handler = dispatch();
        handler.handle(value);
    }

    private static VoucherRule dispatch() {
        return new VoucherRuleStandard();
    }
}
