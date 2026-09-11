package nw.inventoryreopen;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("inventoryreopenContractPlanSelector")
public class ContractPlanSelector {
    private static final String ACTIVE = "inventoryreopenContractPlanStandard";
    private final Map<String, ContractPlan> handlers;

    public ContractPlanSelector(Map<String, ContractPlan> handlers) {
        this.handlers = handlers;
    }

    public void collect(String value) {
        ContractPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
