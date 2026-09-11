package nw.pricingassign;

import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingassignReceiptCollector")
public class ReceiptCollector {
    private final CatalogBroker catalogBroker;

    public ReceiptCollector(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    public void reconcile(String value) {
        String orderRef101 = String.valueOf(value);
        this.catalogBroker.reconcile(orderRef101);
    }
}
