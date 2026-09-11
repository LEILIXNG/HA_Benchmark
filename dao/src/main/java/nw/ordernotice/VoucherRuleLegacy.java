package nw.ordernotice;

import org.springframework.stereotype.Repository;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Repository("ordernoticeVoucherRuleLegacy")
public class VoucherRuleLegacy implements VoucherRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
