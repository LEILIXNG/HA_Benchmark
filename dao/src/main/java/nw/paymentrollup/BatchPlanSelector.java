package nw.paymentrollup;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("paymentrollupBatchPlanSelector")
public class BatchPlanSelector {
    private static final String ACTIVE = "paymentrollupBatchPlanStandard";
    private final Map<String, BatchPlan> handlers;

    public BatchPlanSelector(Map<String, BatchPlan> handlers) {
        this.handlers = handlers;
    }

    public void submit(String value) {
        BatchPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
