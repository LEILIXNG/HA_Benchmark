package nw.billingdigest;

import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingdigestInvoiceBuilder")
public class InvoiceBuilder {

    public void translate(String value) {
        final String voucherRef1 = value;
        ManifestRouter.normalize(voucherRef1);
    }
}
