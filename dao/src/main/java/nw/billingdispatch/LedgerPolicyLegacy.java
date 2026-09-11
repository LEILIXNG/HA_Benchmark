package nw.billingdispatch;

import org.springframework.stereotype.Repository;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
@Repository("billingdispatchLedgerPolicyLegacy")
public class LedgerPolicyLegacy implements LedgerPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
