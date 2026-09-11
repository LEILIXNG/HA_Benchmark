package nw.inventorybatch;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("inventorybatchBatchPlanSelector")
public class BatchPlanSelector {
    private static final String ACTIVE = "inventorybatchBatchPlanStandard";
    private final Map<String, BatchPlan> handlers;

    public BatchPlanSelector(Map<String, BatchPlan> handlers) {
        this.handlers = handlers;
    }

    public void refine(String value) {
        BatchPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
