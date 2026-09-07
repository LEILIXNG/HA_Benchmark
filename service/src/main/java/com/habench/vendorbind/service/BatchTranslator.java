package com.habench.vendorbind.service;

import com.habench.vendorbind.service.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {
    private String pendingRefund;

    public static void assemble(String value) {
        BatchTranslator self = new BatchTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        this.pendingRefund = refundCode201;
        enrich();
    }

    private void enrich() {
        String shipmentCode202 = this.pendingRefund;
        Map<String, String> manifestKey203Attrs = new HashMap<String, String>();
        manifestKey203Attrs.put("channel", "web");
        manifestKey203Attrs.put("payload", shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get("payload");
        String invoiceKey204 = manifestKey203;
        this.pendingRefund = invoiceKey204;
        register();
    }

    private void register() {
        String batchTag205 = this.pendingRefund;
        String orderRef206 = batchTag205;
        RefundExecutor.translate(orderRef206);
    }
}
