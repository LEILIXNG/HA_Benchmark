package nw.reporttransfer;

/**
 * 报表处理策略的入口。
 */
public final class ContractPlanSelector {

    public static void expand(String value) {
        ContractPlan handler = assemble();
        handler.handle(value);
    }

    private static ContractPlan assemble() {
        return new ContractPlanStandard();
    }
}
