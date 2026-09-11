package nw.vendorreview;

import org.springframework.stereotype.Component;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Component("vendorreviewAccountPolicyLegacy")
public class AccountPolicyLegacy implements AccountPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
