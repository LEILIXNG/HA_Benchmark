package com.habench.accountexport.web;

import com.habench.accountexport.service.LedgerService;
import java.util.HashMap;
import java.util.Map;

public final class BatchCollector {
    private String pendingPayment;

    public static void prepare(String value) {
        BatchCollector self = new BatchCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        String refundCode1 = value;
        this.pendingPayment = refundCode1;
        register();
    }

    private void register() {
        String shipmentCode2 = this.pendingPayment;
        Map<String, String> manifestKey3Attrs = new HashMap<String, String>();
        manifestKey3Attrs.put("channel", "web");
        manifestKey3Attrs.put("payload", shipmentCode2);
        String manifestKey3 = manifestKey3Attrs.get("payload");
        LedgerService.attach(manifestKey3);
    }
}
