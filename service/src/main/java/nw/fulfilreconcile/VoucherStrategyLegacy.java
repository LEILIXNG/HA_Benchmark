package nw.fulfilreconcile;

import org.springframework.stereotype.Service;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
@Service("fulfilreconcileVoucherStrategyLegacy")
public class VoucherStrategyLegacy implements VoucherStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
