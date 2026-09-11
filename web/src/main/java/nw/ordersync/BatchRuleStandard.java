package nw.ordersync;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("ordersyncBatchRuleStandard")
public class BatchRuleStandard implements BatchRule {
    private final ContractResolver contractResolver;

    public BatchRuleStandard(ContractResolver contractResolver) {
        this.contractResolver = contractResolver;
    }

    @Override
    public void handle(String value) {
        this.contractResolver.reconcile(value);
    }
}
