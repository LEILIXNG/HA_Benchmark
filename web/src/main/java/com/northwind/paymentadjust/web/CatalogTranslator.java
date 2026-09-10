package com.northwind.paymentadjust.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("paymentadjustCatalogTranslator")
public class CatalogTranslator {
    private String pendingBundle;
    private final InvoicePolicy invoicePolicy;

    public CatalogTranslator(InvoicePolicy invoicePolicy) {
        this.invoicePolicy = invoicePolicy;
    }

    public void merge(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        this.pendingBundle = tariffRef1;
        publish();
    }

    private void publish() {
        String ledgerEntry2 = this.pendingBundle;
        String channelTag3 = "ref_".concat(ledgerEntry2);
        String catalogKey4 = channelTag3;
        this.invoicePolicy.resolve(catalogKey4);
    }
}
