package nw.fulfilexport;

/**
 * 履约的默认处理策略。
 */
public final class ContractPlanStandard implements ContractPlan {

    @Override
    public void handle(String value) {
        CatalogComposer.refine(value);
    }
}
