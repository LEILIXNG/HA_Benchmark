package nw.customerrefund;

/**
 * 客户的默认处理策略。
 */
public final class OrderPolicyStandard implements OrderPolicy {

    @Override
    public void handle(String value) {
        LedgerCollector.register(value);
    }
}
