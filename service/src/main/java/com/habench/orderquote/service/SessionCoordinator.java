package com.habench.orderquote.service;

import com.habench.orderquote.dao.ContractRegistry;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private String pendingBundle;
    private static String cachedBundle;

    public static void submit(String value) {
        SessionCoordinator self = new SessionCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey201 = "ref:" + value + ";";
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingBundle = receiptKey202;
        expand();
    }

    private void expand() {
        String accountRef203 = this.pendingBundle;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        this.pendingBundle = voucherRef204;
        reconcile();
    }

    private void reconcile() {
        String paymentTag205 = this.pendingBundle;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("payload", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("payload");
        String shipmentCode207 = "ref:" + refundCode206 + ";";
        cachedBundle = shipmentCode207;
        enrich();
    }

    private void enrich() {
        String manifestKey208 = cachedBundle;
        String invoiceKey209 = "ref:" + manifestKey208 + ";";
        ContractRegistry.refine(invoiceKey209);
    }
}
