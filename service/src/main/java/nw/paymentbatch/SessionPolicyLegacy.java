package nw.paymentbatch;

import org.springframework.stereotype.Service;

/**
 * 支付的备用处理策略，当前渠道未启用。
 */
@Service("paymentbatchSessionPolicyLegacy")
public class SessionPolicyLegacy implements SessionPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
