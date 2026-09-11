package nw.accounttransfer;

import org.springframework.stereotype.Repository;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
@Repository("accounttransferSessionRuleLegacy")
public class SessionRuleLegacy implements SessionRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
