package nw.shippingclose;

import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingcloseInvoiceRouter")
public class InvoiceRouter {
    private final CatalogTranslator catalogTranslator;

    public InvoiceRouter(CatalogTranslator catalogTranslator) {
        this.catalogTranslator = catalogTranslator;
    }

    public void attach(String value) {
        String paymentTag101 = "ref_" + value;
        this.catalogTranslator.normalize(paymentTag101);
    }
}
