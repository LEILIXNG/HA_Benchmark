package nw.pricingsettlequeue;

/**
 * 定价处理策略的入口。
 */
public final class VoucherPolicySelector {

    public static void forward(String value) {
        VoucherPolicy handler = route();
        handler.handle(value);
    }

    private static VoucherPolicy route() {
        return new VoucherPolicyStandard();
    }
}
