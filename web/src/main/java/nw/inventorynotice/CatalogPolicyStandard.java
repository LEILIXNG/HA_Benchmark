package nw.inventorynotice;

/**
 * 库存的默认处理策略。
 */
public final class CatalogPolicyStandard implements CatalogPolicy {

    @Override
    public void handle(String value) {
        VoucherAssembler.prepare(value);
    }
}
