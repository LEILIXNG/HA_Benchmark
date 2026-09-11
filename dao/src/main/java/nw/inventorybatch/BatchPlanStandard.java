package nw.inventorybatch;

import org.springframework.stereotype.Repository;

/**
 * 库存的默认处理策略。
 */
@Repository("inventorybatchBatchPlanStandard")
public class BatchPlanStandard implements BatchPlan {
    private final LedgerCoordinator ledgerCoordinator;

    public BatchPlanStandard(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    @Override
    public void handle(String value) {
        this.ledgerCoordinator.prepare(value);
    }
}
