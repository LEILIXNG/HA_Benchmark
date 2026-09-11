package nw.reporttrace;

/**
 * 报表的默认处理策略。
 */
public final class PaymentStrategyStandard implements PaymentStrategy {

    @Override
    public void handle(String value) {
        AccountService.submit(value);
    }
}
