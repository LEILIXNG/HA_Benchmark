package com.habench.ordernotice.web;

import com.habench.ordernotice.service.SessionAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void submit(String value) {
        ManifestCollector self = new ManifestCollector();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        this.pendingReceipt = paymentTag1;
        reconcile();
    }

    private void reconcile() {
        String refundCode2 = this.pendingReceipt;
        Map<String, String> shipmentCode3Attrs = new HashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("payload", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get("payload");
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        cachedReceipt = manifestKey4;
        compose();
    }

    private void compose() {
        String invoiceKey5 = cachedReceipt;
        String batchTag6 = "ref:" + invoiceKey5 + ";";
        cachedReceipt = batchTag6;
        resolve();
    }

    private void resolve() {
        String orderRef7 = cachedReceipt;
        Map<String, String> quoteRef8Attrs = new HashMap<String, String>();
        quoteRef8Attrs.put("channel", "web");
        quoteRef8Attrs.put("payload", orderRef7);
        String quoteRef8 = quoteRef8Attrs.get("payload");
        String tariffRef9 = quoteRef8;
        cachedReceipt = tariffRef9;
        normalize();
    }

    private void normalize() {
        String ledgerEntry10 = cachedReceipt;
        String channelTag11 = ledgerEntry10;
        SessionAssembler.reconcile(channelTag11);
    }
}
