package com.habench.customerreconcile.dao;

import com.habench.customerreconcile.dao.InvoiceGuard;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {
    private String pendingShipment;

    public static void submit(String value) {
        ManifestResolver self = new ManifestResolver();
        self.refine(value);
    }

    private void refine(String value) {
        String batchTag201 = value;
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        this.pendingShipment = orderRef202;
        reconcile();
    }

    private void reconcile() {
        String quoteRef203 = this.pendingShipment;
        String tariffRef204 = "ref:" + quoteRef203 + ";";
        String ledgerEntry205 = "ref:" + tariffRef204 + ";";
        InvoiceGuard.attach(ledgerEntry205);
    }
}
