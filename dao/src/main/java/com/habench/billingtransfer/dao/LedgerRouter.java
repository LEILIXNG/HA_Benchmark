package com.habench.billingtransfer.dao;

import com.habench.billingtransfer.dao.ManifestPolicy;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRouter {
    private String pendingRefund;
    private static String cachedRefund;

    public static void collect(String value) {
        LedgerRouter self = new LedgerRouter();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        cachedRefund = paymentTag301;
        publish();
    }

    private void publish() {
        String refundCode302 = cachedRefund;
        String shipmentCode303 = refundCode302;
        this.pendingRefund = shipmentCode303;
        merge();
    }

    private void merge() {
        String manifestKey304 = this.pendingRefund;
        String invoiceKey305 = manifestKey304;
        Map<String, String> batchTag306Attrs = new HashMap<String, String>();
        batchTag306Attrs.put("channel", "web");
        batchTag306Attrs.put("payload", invoiceKey305);
        String batchTag306 = batchTag306Attrs.get("payload");
        ManifestPolicy.submit(batchTag306);
    }
}
