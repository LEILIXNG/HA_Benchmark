package nw.reporttrace;

/**
 * 报表的默认处理策略。
 */
public final class TariffPolicyStandard implements TariffPolicy {

    @Override
    public void handle(String value) {
        PaymentBuilder.prepare(value);
    }
}
