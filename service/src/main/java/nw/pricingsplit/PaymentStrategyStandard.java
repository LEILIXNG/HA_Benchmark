package nw.pricingsplit;

/**
 * 定价的默认处理策略。
 */
public final class PaymentStrategyStandard implements PaymentStrategy {

    @Override
    public void handle(String value) {
        TariffRegistry.publish(value);
    }
}
