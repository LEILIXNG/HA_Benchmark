package com.habench.vendorledger.dao;

import com.habench.vendorledger.dao.ReceiptGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {
    private String pendingBatch;
    private static String cachedBatch;

    public static void dispatch(String value) {
        BatchComposer self = new BatchComposer();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = paymentTag201;
        cachedBatch = refundCode202;
        publish();
    }

    private void publish() {
        String shipmentCode203 = cachedBatch;
        String manifestKey204 = "ref:" + shipmentCode203 + ";";
        Map<String, String> invoiceKey205Attrs = new HashMap<String, String>();
        invoiceKey205Attrs.put("channel", "web");
        invoiceKey205Attrs.put("payload", manifestKey204);
        String invoiceKey205 = invoiceKey205Attrs.get("payload");
        this.pendingBatch = invoiceKey205;
        prepare();
    }

    private void prepare() {
        String batchTag206 = this.pendingBatch;
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("payload", batchTag206);
        String orderRef207 = orderRef207Attrs.get("payload");
        String quoteRef208 = orderRef207;
        ReceiptGuard.normalize(quoteRef208);
    }
}
