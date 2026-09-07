package com.habench.inventorydigest.web;

import com.habench.inventorydigest.service.AccountRegistry;
import java.util.HashMap;
import java.util.Map;

public final class LedgerEnricher {
    private String pendingAccount;

    public static void refine(String value) {
        LedgerEnricher self = new LedgerEnricher();
        self.enrich(value);
    }

    private void enrich(String value) {
        String receiptKey1 = value;
        String accountRef2 = "ref:" + receiptKey1 + ";";
        this.pendingAccount = accountRef2;
        publish();
    }

    private void publish() {
        String voucherRef3 = this.pendingAccount;
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        Map<String, String> refundCode5Attrs = new HashMap<String, String>();
        refundCode5Attrs.put("channel", "web");
        refundCode5Attrs.put("payload", paymentTag4);
        String refundCode5 = refundCode5Attrs.get("payload");
        this.pendingAccount = refundCode5;
        compose();
    }

    private void compose() {
        String shipmentCode6 = this.pendingAccount;
        String manifestKey7 = shipmentCode6;
        Map<String, String> invoiceKey8Attrs = new HashMap<String, String>();
        invoiceKey8Attrs.put("channel", "web");
        invoiceKey8Attrs.put("payload", manifestKey7);
        String invoiceKey8 = invoiceKey8Attrs.get("payload");
        this.pendingAccount = invoiceKey8;
        reconcile();
    }

    private void reconcile() {
        String batchTag9 = this.pendingAccount;
        String orderRef10 = "ref:" + batchTag9 + ";";
        String quoteRef11 = orderRef10;
        AccountRegistry.route(quoteRef11);
    }
}
