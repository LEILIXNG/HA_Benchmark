package com.habench.inventorylookup.service;

import com.habench.inventorylookup.service.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingBatch;
    private static String cachedBatch;

    public static void collect(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.compose(value);
    }

    private void compose(String value) {
        String accountRef201 = value;
        String voucherRef202 = "ref:" + accountRef201 + ";";
        cachedBatch = voucherRef202;
        assemble();
    }

    private void assemble() {
        String paymentTag203 = cachedBatch;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        this.pendingBatch = refundCode204;
        translate();
    }

    private void translate() {
        String shipmentCode205 = this.pendingBatch;
        String manifestKey206 = "ref:" + shipmentCode205 + ";";
        Map<String, String> invoiceKey207Attrs = new HashMap<String, String>();
        invoiceKey207Attrs.put("channel", "web");
        invoiceKey207Attrs.put("payload", manifestKey206);
        String invoiceKey207 = invoiceKey207Attrs.get("payload");
        BatchExecutor.assemble(invoiceKey207);
    }
}
