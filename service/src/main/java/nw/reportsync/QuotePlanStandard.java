package nw.reportsync;

/**
 * 报表的默认处理策略。
 */
public final class QuotePlanStandard implements QuotePlan {

    @Override
    public void handle(String value) {
        ChannelCoordinator.translate(value);
    }
}
