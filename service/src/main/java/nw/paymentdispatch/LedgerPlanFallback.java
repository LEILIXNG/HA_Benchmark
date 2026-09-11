package nw.paymentdispatch;

import org.springframework.stereotype.Service;

/**
 * 支付的备用处理策略，当前渠道未启用。
 */
@Service("paymentdispatchLedgerPlanFallback")
public class LedgerPlanFallback implements LedgerPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
