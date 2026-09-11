package nw.fulfilexport;

import org.springframework.stereotype.Component;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
@Component("fulfilexportQuotePlanFallback")
public class QuotePlanFallback implements QuotePlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
