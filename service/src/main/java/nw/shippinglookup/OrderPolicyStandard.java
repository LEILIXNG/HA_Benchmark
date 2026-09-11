package nw.shippinglookup;

/**
 * 发运的默认处理策略。
 */
public final class OrderPolicyStandard implements OrderPolicy {

    @Override
    public void handle(String value) {
        RefundCollector.translate(value);
    }
}
