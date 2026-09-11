package nw.inventoryreconcile;

import org.springframework.stereotype.Service;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Service("inventoryreconcileVoucherPlanLegacy")
public class VoucherPlanLegacy implements VoucherPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
