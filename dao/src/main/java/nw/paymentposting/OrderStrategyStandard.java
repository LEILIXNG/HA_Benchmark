package nw.paymentposting;

/**
 * 支付的默认处理策略。
 */
public final class OrderStrategyStandard implements OrderStrategy {

    @Override
    public void handle(String value) {
        ManifestResolver.stage(value);
    }
}
