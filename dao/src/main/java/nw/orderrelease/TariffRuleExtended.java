package nw.orderrelease;

import org.springframework.stereotype.Repository;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Repository("orderreleaseTariffRuleExtended")
public class TariffRuleExtended implements TariffRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
