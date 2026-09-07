package com.habench.paymentrollup.dao;

import com.habench.paymentrollup.dao.BatchPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {
    private String pendingInvoice;

    public static void enrich(String value) {
        VoucherAssembler self = new VoucherAssembler();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        this.pendingInvoice = shipmentCode402;
        stage();
    }

    private void stage() {
        String manifestKey403 = this.pendingInvoice;
        Map<String, String> invoiceKey404Attrs = new HashMap<String, String>();
        invoiceKey404Attrs.put("channel", "web");
        invoiceKey404Attrs.put("payload", manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.get("payload");
        String batchTag405 = "ref:" + invoiceKey404 + ";";
        BatchPlanSelector.submit(batchTag405);
    }
}
