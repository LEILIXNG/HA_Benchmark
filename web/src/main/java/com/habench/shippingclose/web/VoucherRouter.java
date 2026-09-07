package com.habench.shippingclose.web;

import com.habench.shippingclose.web.CatalogPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingQuote;

    public static void forward(String value) {
        VoucherRouter self = new VoucherRouter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String receiptKey1 = "ref:" + value + ";";
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        this.pendingQuote = accountRef2;
        stage();
    }

    private void stage() {
        String voucherRef3 = this.pendingQuote;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        String refundCode5 = paymentTag4;
        this.pendingQuote = refundCode5;
        merge();
    }

    private void merge() {
        String shipmentCode6 = this.pendingQuote;
        String manifestKey7 = shipmentCode6;
        String invoiceKey8 = manifestKey7;
        CatalogPlanSelector.publish(invoiceKey8);
    }
}
