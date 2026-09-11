package nw.fulfilexport;

/**
 * 履约处理策略的入口。
 */
public final class ContractPlanSelector {

    public static void refine(String value) {
        ContractPlan handler = dispatch();
        handler.handle(value);
    }

    private static ContractPlan dispatch() {
        return new ContractPlanStandard();
    }
}
