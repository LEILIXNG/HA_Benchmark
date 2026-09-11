package nw.inventoryreopen;

import org.springframework.stereotype.Service;

/**
 * 库存的默认处理策略。
 */
@Service("inventoryreopenContractPlanStandard")
public class ContractPlanStandard implements ContractPlan {
    private final OrderAdapter orderAdapter;

    public ContractPlanStandard(OrderAdapter orderAdapter) {
        this.orderAdapter = orderAdapter;
    }

    @Override
    public void handle(String value) {
        this.orderAdapter.assemble(value);
    }
}
