package com.habench.fulfilreopen.dao;

import com.habench.fulfilreopen.dao.RefundEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {
    private String pendingRefund;

    public static void collect(String value) {
        BatchBuilder self = new BatchBuilder();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        String orderRef302 = batchTag301;
        this.pendingRefund = orderRef302;
        merge();
    }

    private void merge() {
        String quoteRef303 = this.pendingRefund;
        String tariffRef304 = quoteRef303;
        String ledgerEntry305 = tariffRef304;
        RefundEvaluator.submit(ledgerEntry305);
    }
}
