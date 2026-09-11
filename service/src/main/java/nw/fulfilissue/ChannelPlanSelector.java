package nw.fulfilissue;

/**
 * 履约处理策略的入口。
 */
public final class ChannelPlanSelector {

    public static void merge(String value) {
        ChannelPlan handler = forward();
        handler.handle(value);
    }

    private static ChannelPlan forward() {
        return new ChannelPlanStandard();
    }
}
