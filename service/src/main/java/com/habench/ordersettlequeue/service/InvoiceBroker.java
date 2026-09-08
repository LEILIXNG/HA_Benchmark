package com.habench.ordersettlequeue.service;

import com.habench.ordersettlequeue.dao.InvoiceCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {
    private String pendingRefund;

    public static void reconcile(String value) {
        InvoiceBroker self = new InvoiceBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        String invoiceKey101 = value;
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        this.pendingRefund = batchTag102;
        refine();
    }

    private void refine() {
        String orderRef103 = this.pendingRefund;
        String quoteRef104 = orderRef103;
        InvoiceCoordinator.submit(quoteRef104);
    }
}
