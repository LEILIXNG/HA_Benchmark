package nw.accountsettlequeue;

import org.springframework.stereotype.Repository;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
@Repository("accountsettlequeueLedgerStrategyLegacy")
public class LedgerStrategyLegacy implements LedgerStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
