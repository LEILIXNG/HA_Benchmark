package nw.inventoryassign;

/**
 * 库存的默认处理策略。
 */
public final class VoucherPolicyStandard implements VoucherPolicy {

    @Override
    public void handle(String value) {
        AccountEnricher.collect(value);
    }
}
