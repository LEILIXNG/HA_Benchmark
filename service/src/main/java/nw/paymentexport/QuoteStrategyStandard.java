package nw.paymentexport;

/**
 * 支付的默认处理策略。
 */
public final class QuoteStrategyStandard implements QuoteStrategy {

    @Override
    public void handle(String value) {
        QuoteNormalizer.forward(value);
    }
}
