package com.habench.vendorarchive.web;

import com.habench.vendorarchive.web.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBuilder {
    private String pendingPayment;

    public static void prepare(String value) {
        CatalogBuilder self = new CatalogBuilder();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = "ref:" + receiptKey1 + ";";
        this.pendingPayment = accountRef2;
        attach();
    }

    private void attach() {
        String voucherRef3 = this.pendingPayment;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        String refundCode5 = paymentTag4;
        AccountStrategySelector.attach(refundCode5);
    }
}
