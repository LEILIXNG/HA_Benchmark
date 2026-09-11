package nw.catalogrefund;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogrefundBatchPolicyStandard")
public class BatchPolicyStandard implements BatchPolicy {
    private final LedgerCoordinator ledgerCoordinator;

    public BatchPolicyStandard(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    @Override
    public void handle(String value) {
        this.ledgerCoordinator.route(value);
    }
}
