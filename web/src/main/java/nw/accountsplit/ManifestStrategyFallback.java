package nw.accountsplit;

import org.springframework.stereotype.Component;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
@Component("accountsplitManifestStrategyFallback")
public class ManifestStrategyFallback implements ManifestStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
