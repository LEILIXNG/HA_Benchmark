package nw.billingdigest;

/**
 * 账务的默认处理策略。
 */
public final class BatchPlanStandard implements BatchPlan {

    @Override
    public void handle(String value) {
        ManifestAdapter.normalize(value);
    }
}
