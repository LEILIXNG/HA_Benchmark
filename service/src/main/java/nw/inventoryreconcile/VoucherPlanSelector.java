package nw.inventoryreconcile;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("inventoryreconcileVoucherPlanSelector")
public class VoucherPlanSelector {
    private static final String ACTIVE = "inventoryreconcileVoucherPlanStandard";
    private final Map<String, VoucherPlan> handlers;

    public VoucherPlanSelector(Map<String, VoucherPlan> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        VoucherPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
