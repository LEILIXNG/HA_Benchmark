package nw.shippingtransfer;

import org.springframework.stereotype.Component;

/**
 * 发运的备用处理策略，当前渠道未启用。
 */
@Component("shippingtransferAccountPlanLegacy")
public class AccountPlanLegacy implements AccountPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
