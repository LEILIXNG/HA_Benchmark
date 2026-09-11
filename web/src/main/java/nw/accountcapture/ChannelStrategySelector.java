package nw.accountcapture;

/**
 * 账户处理策略的入口。
 */
public final class ChannelStrategySelector {

    public static void forward(String value) {
        ChannelStrategy handler = submit();
        handler.handle(value);
    }

    private static ChannelStrategy submit() {
        return new ChannelStrategyStandard();
    }
}
