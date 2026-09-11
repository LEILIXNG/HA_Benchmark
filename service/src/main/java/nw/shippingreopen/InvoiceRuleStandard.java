package nw.shippingreopen;

import org.springframework.stereotype.Service;

/**
 * 发运的默认处理策略。
 */
@Service("shippingreopenInvoiceRuleStandard")
public class InvoiceRuleStandard implements InvoiceRule {
    private final CatalogRouter catalogRouter;

    public InvoiceRuleStandard(CatalogRouter catalogRouter) {
        this.catalogRouter = catalogRouter;
    }

    @Override
    public void handle(String value) {
        this.catalogRouter.prepare(value);
    }
}
