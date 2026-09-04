package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.SessionPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void stage(String value) {
        RefundCollector self = new RefundCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        cachedCatalog = catalogKey1;
        merge();
    }

    private void merge() {
        String receiptKey2 = cachedCatalog;
        String accountRef3 = receiptKey2;
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        cachedCatalog = voucherRef4;
        assemble();
    }

    private void assemble() {
        String paymentTag5 = cachedCatalog;
        String refundCode6 = paymentTag5;
        cachedCatalog = refundCode6;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode7 = cachedCatalog;
        String manifestKey8 = shipmentCode7;
        this.pendingCatalog = manifestKey8;
        register();
    }

    private void register() {
        String invoiceKey9 = this.pendingCatalog;
        String batchTag10 = "ref:" + invoiceKey9 + ";";
        this.pendingCatalog = batchTag10;
        reconcile();
    }

    private void reconcile() {
        String orderRef11 = this.pendingCatalog;
        String quoteRef12 = orderRef11;
        this.pendingCatalog = quoteRef12;
        submit();
    }

    private void submit() {
        String tariffRef13 = this.pendingCatalog;
        String ledgerEntry14 = "ref:" + tariffRef13 + ";";
        String channelTag15 = "ref:" + ledgerEntry14 + ";";
        SessionPolicySelector.collect(channelTag15);
    }
}
