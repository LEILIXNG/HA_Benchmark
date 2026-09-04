package com.habench.billingtransfer.service;

import com.habench.billingtransfer.dao.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {
    private String pendingBatch;

    public static void collect(String value) {
        InvoiceService self = new InvoiceService();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = "ref:" + paymentTag201 + ";";
        this.pendingBatch = refundCode202;
        stage();
    }

    private void stage() {
        String shipmentCode203 = this.pendingBatch;
        String manifestKey204 = "ref:" + shipmentCode203 + ";";
        this.pendingBatch = manifestKey204;
        submit();
    }

    private void submit() {
        String invoiceKey205 = this.pendingBatch;
        String batchTag206 = invoiceKey205;
        String orderRef207 = batchTag206;
        CatalogAdapter.refine(orderRef207);
    }
}
