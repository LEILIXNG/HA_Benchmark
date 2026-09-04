package com.habench.billingreconcile.web;

import com.habench.billingreconcile.service.OrderBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private String pendingPayment;
    private static String cachedPayment;

    public static void attach(String value) {
        ReceiptCoordinator self = new ReceiptCoordinator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        this.pendingPayment = tariffRef2;
        stage();
    }

    private void stage() {
        String ledgerEntry3 = this.pendingPayment;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        String catalogKey5 = "ref:" + channelTag4 + ";";
        cachedPayment = catalogKey5;
        merge();
    }

    private void merge() {
        String receiptKey6 = cachedPayment;
        String accountRef7 = receiptKey6;
        Map<String, String> voucherRef8Attrs = new HashMap<String, String>();
        voucherRef8Attrs.put("channel", "web");
        voucherRef8Attrs.put("payload", accountRef7);
        String voucherRef8 = voucherRef8Attrs.get("payload");
        OrderBuilder.attach(voucherRef8);
    }
}
