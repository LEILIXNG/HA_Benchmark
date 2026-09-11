package nw.inventoryassign;

/**
 * 库存的默认处理策略。
 */
public final class AccountPlanStandard implements AccountPlan {

    @Override
    public void handle(String value) {
        InvoiceRegistry.publish(value);
    }
}
