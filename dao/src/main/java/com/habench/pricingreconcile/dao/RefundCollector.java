package com.habench.pricingreconcile.dao;

import com.habench.pricingreconcile.dao.VoucherExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private String pendingVoucher;

    public static void register(String value) {
        RefundCollector self = new RefundCollector();
        self.merge(value);
    }

    private void merge(String value) {
        String invoiceKey401 = value;
        String batchTag402 = invoiceKey401;
        this.pendingVoucher = batchTag402;
        expand();
    }

    private void expand() {
        String orderRef403 = this.pendingVoucher;
        String quoteRef404 = orderRef403;
        Map<String, String> tariffRef405Attrs = new HashMap<String, String>();
        tariffRef405Attrs.put("channel", "web");
        tariffRef405Attrs.put("payload", quoteRef404);
        String tariffRef405 = tariffRef405Attrs.get("payload");
        VoucherExecutor.dispatch(tariffRef405);
    }
}
