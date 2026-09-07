package com.habench.inventorysettlequeue.dao;

import com.habench.inventorysettlequeue.dao.RefundFetcher;
import java.util.HashMap;
import java.util.Map;

public final class BatchRegistry {
    private String pendingRefund;
    private static String cachedRefund;

    public static void reconcile(String value) {
        BatchRegistry self = new BatchRegistry();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> catalogKey401Attrs = new HashMap<String, String>();
        catalogKey401Attrs.put("channel", "web");
        catalogKey401Attrs.put("payload", value);
        String catalogKey401 = catalogKey401Attrs.get("payload");
        cachedRefund = catalogKey401;
        enrich();
    }

    private void enrich() {
        String receiptKey402 = cachedRefund;
        Map<String, String> accountRef403Attrs = new HashMap<String, String>();
        accountRef403Attrs.put("channel", "web");
        accountRef403Attrs.put("payload", receiptKey402);
        String accountRef403 = accountRef403Attrs.get("payload");
        Map<String, String> voucherRef404Attrs = new HashMap<String, String>();
        voucherRef404Attrs.put("channel", "web");
        voucherRef404Attrs.put("payload", accountRef403);
        String voucherRef404 = voucherRef404Attrs.get("payload");
        this.pendingRefund = voucherRef404;
        collect();
    }

    private void collect() {
        String paymentTag405 = this.pendingRefund;
        Map<String, String> refundCode406Attrs = new HashMap<String, String>();
        refundCode406Attrs.put("channel", "web");
        refundCode406Attrs.put("payload", paymentTag405);
        String refundCode406 = refundCode406Attrs.get("payload");
        String shipmentCode407 = refundCode406;
        RefundFetcher.compose(shipmentCode407);
    }
}
