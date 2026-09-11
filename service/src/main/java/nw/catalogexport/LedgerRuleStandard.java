package nw.catalogexport;

/**
 * 商品的默认处理策略。
 */
public final class LedgerRuleStandard implements LedgerRule {

    @Override
    public void handle(String value) {
        ChannelResolver.publish(value);
    }
}
