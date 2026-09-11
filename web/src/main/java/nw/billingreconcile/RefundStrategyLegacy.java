package nw.billingreconcile;

import org.springframework.stereotype.Component;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
@Component("billingreconcileRefundStrategyLegacy")
public class RefundStrategyLegacy implements RefundStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
