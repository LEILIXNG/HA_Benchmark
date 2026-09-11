package nw.paymentledger;

/**
 * 支付的默认处理策略。
 */
public final class LedgerPlanStandard implements LedgerPlan {

    @Override
    public void handle(String value) {
        ContractFacade.prepare(value);
    }
}
