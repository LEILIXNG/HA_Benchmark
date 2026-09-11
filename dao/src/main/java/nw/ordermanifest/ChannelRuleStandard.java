package nw.ordermanifest;

/**
 * 订单的默认处理策略。
 */
public final class ChannelRuleStandard implements ChannelRule {

    @Override
    public void handle(String value) {
        InvoiceResolver.merge(value);
    }
}
