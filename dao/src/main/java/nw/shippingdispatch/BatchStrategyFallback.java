package nw.shippingdispatch;

import org.springframework.stereotype.Repository;

/**
 * 发运的备用处理策略，当前渠道未启用。
 */
@Repository("shippingdispatchBatchStrategyFallback")
public class BatchStrategyFallback implements BatchStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
