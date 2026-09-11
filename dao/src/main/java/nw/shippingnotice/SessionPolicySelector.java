package nw.shippingnotice;

/**
 * 发运处理策略的入口。
 */
public final class SessionPolicySelector {

    public static void compose(String value) {
        SessionPolicy handler = forward();
        handler.handle(value);
    }

    private static SessionPolicy forward() {
        return new SessionPolicyStandard();
    }
}
