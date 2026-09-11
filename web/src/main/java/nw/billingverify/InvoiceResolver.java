package nw.billingverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账务场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceResolver {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceResolver.class);
    private String pendingCatalog;

    public static void enrich(String value) {
        LOG.debug("账务流程转下一环节");
        InvoiceResolver self = new InvoiceResolver();
        self.compose(value);
    }

    private void compose(String value) {
        String invoiceKey201 = "ref_".concat(value);
        String batchTag202 = invoiceKey201;
        this.pendingCatalog = batchTag202;
        publish();
    }

    private void publish() {
        String orderRef203 = this.pendingCatalog;
        final String quoteRef204 = orderRef203;
        CatalogRepository.expand(quoteRef204);
    }
}
