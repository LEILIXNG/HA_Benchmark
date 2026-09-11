package nw.reporttransfer;

/**
 * 报表的默认处理策略。
 */
public final class SessionRuleStandard implements SessionRule {

    @Override
    public void handle(String value) {
        ShipmentTranslator.submit(value);
    }
}
