package nw.orderreopen;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
public final class ReceiptPolicyLegacy implements ReceiptPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
