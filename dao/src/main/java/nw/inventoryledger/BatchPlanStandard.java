package nw.inventoryledger;

/**
 * 库存的默认处理策略。
 */
public final class BatchPlanStandard implements BatchPlan {

    @Override
    public void handle(String value) {
        ManifestBroker.dispatch(value);
    }
}
