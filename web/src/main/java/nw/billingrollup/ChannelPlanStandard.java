package nw.billingrollup;

/**
 * 账务的默认处理策略。
 */
public final class ChannelPlanStandard implements ChannelPlan {

    @Override
    public void handle(String value) {
        AccountComposer.resolve(value);
    }
}
