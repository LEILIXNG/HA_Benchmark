package nw.pricingreconcile;

/**
 * 定价处理策略的入口。
 */
public final class AccountPolicySelector {

    public static void route(String value) {
        AccountPolicy handler = assemble();
        handler.handle(value);
    }

    private static AccountPolicy assemble() {
        return new AccountPolicyStandard();
    }
}
