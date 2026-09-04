package com.habench.accounttrace.dao;

import com.habench.accounttrace.dao.BatchExecutor;

public final class ReceiptBuilder {
    private String pendingBatch;
    private static String cachedBatch;

    public static void expand(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.stage(value);
    }

    private void stage(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = "ref:" + refundCode201 + ";";
        this.pendingBatch = shipmentCode202;
        collect();
    }

    private void collect() {
        String manifestKey203 = this.pendingBatch;
        String invoiceKey204 = manifestKey203;
        cachedBatch = invoiceKey204;
        compose();
    }

    private void compose() {
        String batchTag205 = cachedBatch;
        String orderRef206 = "ref:" + batchTag205 + ";";
        this.pendingBatch = orderRef206;
        route();
    }

    private void route() {
        String quoteRef207 = this.pendingBatch;
        String tariffRef208 = quoteRef207;
        BatchExecutor.prepare(tariffRef208);
    }
}
