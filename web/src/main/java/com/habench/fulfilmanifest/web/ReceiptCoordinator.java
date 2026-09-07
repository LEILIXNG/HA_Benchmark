package com.habench.fulfilmanifest.web;

import com.habench.fulfilmanifest.service.CatalogTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private String pendingChannel;

    public static void normalize(String value) {
        ReceiptCoordinator self = new ReceiptCoordinator();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        this.pendingChannel = accountRef2;
        publish();
    }

    private void publish() {
        String voucherRef3 = this.pendingChannel;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        Map<String, String> refundCode5Attrs = new HashMap<String, String>();
        refundCode5Attrs.put("channel", "web");
        refundCode5Attrs.put("payload", paymentTag4);
        String refundCode5 = refundCode5Attrs.get("payload");
        CatalogTranslator.expand(refundCode5);
    }
}
