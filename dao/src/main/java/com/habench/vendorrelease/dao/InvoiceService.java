package com.habench.vendorrelease.dao;

import com.habench.vendorrelease.dao.LedgerGateway;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {
    private String pendingLedger;

    public static void stage(String value) {
        InvoiceService self = new InvoiceService();
        self.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey401 = "ref:" + value + ";";
        this.pendingLedger = manifestKey401;
        forward();
    }

    private void forward() {
        String invoiceKey402 = this.pendingLedger;
        Map<String, String> batchTag403Attrs = new HashMap<String, String>();
        batchTag403Attrs.put("channel", "web");
        batchTag403Attrs.put("payload", invoiceKey402);
        String batchTag403 = batchTag403Attrs.get("payload");
        LedgerGateway.translate(batchTag403);
    }
}
