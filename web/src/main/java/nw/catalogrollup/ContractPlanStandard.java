package nw.catalogrollup;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogrollupContractPlanStandard")
public class ContractPlanStandard implements ContractPlan {
    private final OrderRegistry orderRegistry;

    public ContractPlanStandard(OrderRegistry orderRegistry) {
        this.orderRegistry = orderRegistry;
    }

    @Override
    public void handle(String value) {
        this.orderRegistry.forward(value);
    }
}
