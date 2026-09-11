package nw.billingrelease;

/**
 * 账务的默认处理策略。
 */
public final class ChannelStrategyStandard implements ChannelStrategy {

    @Override
    public void handle(String value) {
        QuoteNormalizer.register(value);
    }
}
