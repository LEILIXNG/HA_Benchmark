package nw.fulfilreopen;

/**
 * 履约处理策略的入口。
 */
public final class VoucherPolicySelector {

    public static void merge(String value) {
        VoucherPolicy handler = route();
        handler.handle(value);
    }

    private static VoucherPolicy route() {
        return new VoucherPolicyStandard();
    }
}
