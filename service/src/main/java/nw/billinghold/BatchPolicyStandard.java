package nw.billinghold;

import org.springframework.stereotype.Service;

/**
 * 账务的默认处理策略。
 */
@Service("billingholdBatchPolicyStandard")
public class BatchPolicyStandard implements BatchPolicy {
    private final ContractRouter contractRouter;

    public BatchPolicyStandard(ContractRouter contractRouter) {
        this.contractRouter = contractRouter;
    }

    @Override
    public void handle(String value) {
        this.contractRouter.attach(value);
    }
}
