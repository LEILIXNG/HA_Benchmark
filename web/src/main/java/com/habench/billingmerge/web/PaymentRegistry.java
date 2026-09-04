package com.habench.billingmerge.web;

import com.habench.billingmerge.service.RefundEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {
    private String pendingQuote;
    private static String cachedQuote;

    public static void refine(String value) {
        PaymentRegistry self = new PaymentRegistry();
        self.merge(value);
    }

    private void merge(String value) {
        String receiptKey1 = value;
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        this.pendingQuote = accountRef2;
        route();
    }

    private void route() {
        String voucherRef3 = this.pendingQuote;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        cachedQuote = paymentTag4;
        stage();
    }

    private void stage() {
        String refundCode5 = cachedQuote;
        String shipmentCode6 = "ref:" + refundCode5 + ";";
        RefundEnricher.forward(shipmentCode6);
    }
}
