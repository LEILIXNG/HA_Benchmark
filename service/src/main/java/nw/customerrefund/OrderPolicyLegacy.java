package nw.customerrefund;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
public final class OrderPolicyLegacy implements OrderPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
