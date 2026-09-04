package com.habench.paymentsync.web;

import com.habench.paymentsync.service.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void resolve(String value) {
        CatalogCollector self = new CatalogCollector();
        self.stage(value);
    }

    private void stage(String value) {
        String batchTag1 = "ref:" + value + ";";
        String orderRef2 = "ref:" + batchTag1 + ";";
        this.pendingReceipt = orderRef2;
        reconcile();
    }

    private void reconcile() {
        String quoteRef3 = this.pendingReceipt;
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        cachedReceipt = ledgerEntry5;
        forward();
    }

    private void forward() {
        String channelTag6 = cachedReceipt;
        String catalogKey7 = "ref:" + channelTag6 + ";";
        cachedReceipt = catalogKey7;
        register();
    }

    private void register() {
        String receiptKey8 = cachedReceipt;
        String accountRef9 = receiptKey8;
        String voucherRef10 = "ref:" + accountRef9 + ";";
        this.pendingReceipt = voucherRef10;
        publish();
    }

    private void publish() {
        String paymentTag11 = this.pendingReceipt;
        Map<String, String> refundCode12Attrs = new HashMap<String, String>();
        refundCode12Attrs.put("channel", "web");
        refundCode12Attrs.put("payload", paymentTag11);
        String refundCode12 = refundCode12Attrs.get("payload");
        String shipmentCode13 = "ref:" + refundCode12 + ";";
        BundleAdapter.attach(shipmentCode13);
    }
}
