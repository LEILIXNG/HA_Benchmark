package nw.shippingsubmit;

/**
 * 发运处理策略的入口。
 */
public final class ChannelPolicySelector {

    public static void route(String value) {
        ChannelPolicy handler = stage();
        handler.handle(value);
    }

    private static ChannelPolicy stage() {
        return new ChannelPolicyStandard();
    }
}
