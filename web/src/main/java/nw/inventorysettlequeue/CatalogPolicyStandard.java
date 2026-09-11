package nw.inventorysettlequeue;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventorysettlequeueCatalogPolicyStandard")
public class CatalogPolicyStandard implements CatalogPolicy {
    private final ReceiptRouter receiptRouter;

    public CatalogPolicyStandard(ReceiptRouter receiptRouter) {
        this.receiptRouter = receiptRouter;
    }

    @Override
    public void handle(String value) {
        this.receiptRouter.assemble(value);
    }
}
