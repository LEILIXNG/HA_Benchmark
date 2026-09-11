package nw.orderissue;

/**
 * 订单的默认处理策略。
 */
public final class ChannelRuleStandard implements ChannelRule {

    @Override
    public void handle(String value) {
        QuoteFacade.assemble(value);
    }
}
