package com.habench.accounttrace.dao;

import com.habench.accounttrace.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBuilder {
    private String pendingBatch;
    private static String cachedBatch;

    public static void expand(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = shipmentCode301;
        this.pendingBatch = manifestKey302;
        collect();
    }

    private void collect() {
        String invoiceKey303 = this.pendingBatch;
        String batchTag304 = invoiceKey303;
        cachedBatch = batchTag304;
        compose();
    }

    private void compose() {
        String orderRef305 = cachedBatch;
        String quoteRef306 = "ref:" + orderRef305 + ";";
        this.pendingBatch = quoteRef306;
        route();
    }

    private void route() {
        String tariffRef307 = this.pendingBatch;
        Map<String, String> ledgerEntry308Attrs = new HashMap<String, String>();
        ledgerEntry308Attrs.put("channel", "web");
        ledgerEntry308Attrs.put("payload", tariffRef307);
        String ledgerEntry308 = ledgerEntry308Attrs.get("payload");
        BatchExecutor.prepare(ledgerEntry308);
    }
}
