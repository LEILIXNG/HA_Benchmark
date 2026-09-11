package nw.reporttransfer;

/**
 * 报表处理策略的入口。
 */
public final class SessionRuleSelector {

    public static void forward(String value) {
        SessionRule handler = normalize();
        handler.handle(value);
    }

    private static SessionRule normalize() {
        return new SessionRuleStandard();
    }
}
