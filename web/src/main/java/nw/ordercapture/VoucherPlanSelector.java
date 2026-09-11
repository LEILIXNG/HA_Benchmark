package nw.ordercapture;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("ordercaptureVoucherPlanSelector")
public class VoucherPlanSelector {
    private static final String ACTIVE = "ordercaptureVoucherPlanStandard";
    private final Map<String, VoucherPlan> handlers;

    public VoucherPlanSelector(Map<String, VoucherPlan> handlers) {
        this.handlers = handlers;
    }

    public void reconcile(String value) {
        VoucherPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
