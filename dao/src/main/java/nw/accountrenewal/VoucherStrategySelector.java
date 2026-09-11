package nw.accountrenewal;

/**
 * 账户处理策略的入口。
 */
public final class VoucherStrategySelector {

    public static void assemble(String value) {
        VoucherStrategy handler = reconcile();
        handler.handle(value);
    }

    private static VoucherStrategy reconcile() {
        return new VoucherStrategyStandard();
    }
}
