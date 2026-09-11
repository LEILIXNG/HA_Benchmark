package nw.pricingdraft;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingdraftSessionStrategyStandard")
public class SessionStrategyStandard implements SessionStrategy {
    private final BatchCollector batchCollector;

    public SessionStrategyStandard(BatchCollector batchCollector) {
        this.batchCollector = batchCollector;
    }

    @Override
    public void handle(String value) {
        this.batchCollector.reconcile(value);
    }
}
