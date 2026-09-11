package nw.fulfilsplit;

import org.springframework.stereotype.Repository;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
@Repository("fulfilsplitAccountRuleLegacy")
public class AccountRuleLegacy implements AccountRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
