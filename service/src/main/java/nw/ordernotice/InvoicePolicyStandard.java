package nw.ordernotice;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("ordernoticeInvoicePolicyStandard")
public class InvoicePolicyStandard implements InvoicePolicy {
    private final CatalogBroker catalogBroker;

    public InvoicePolicyStandard(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    @Override
    public void handle(String value) {
        this.catalogBroker.compose(value);
    }
}
