package nw.customerposting;

/**
 * 客户处理策略的入口。
 */
public final class AccountStrategySelector {

    public static void prepare(String value) {
        AccountStrategy handler = normalize();
        handler.handle(value);
    }

    private static AccountStrategy normalize() {
        return new AccountStrategyStandard();
    }
}
