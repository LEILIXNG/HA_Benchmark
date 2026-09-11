package nw.reportbind;

import org.springframework.stereotype.Service;

/**
 * 报表的默认处理策略。
 */
@Service("reportbindBatchPlanStandard")
public class BatchPlanStandard implements BatchPlan {
    private final ContractEnricher contractEnricher;

    public BatchPlanStandard(ContractEnricher contractEnricher) {
        this.contractEnricher = contractEnricher;
    }

    @Override
    public void handle(String value) {
        this.contractEnricher.enrich(value);
    }
}
