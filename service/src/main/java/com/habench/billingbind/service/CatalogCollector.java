package com.habench.billingbind.service;

import com.habench.billingbind.dao.SessionFacade;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void merge(String value) {
        CatalogCollector self = new CatalogCollector();
        self.stage(value);
    }

    private void stage(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        cachedReceipt = shipmentCode101;
        collect();
    }

    private void collect() {
        String manifestKey102 = cachedReceipt;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        String batchTag104 = "ref:" + invoiceKey103 + ";";
        this.pendingReceipt = batchTag104;
        compose();
    }

    private void compose() {
        String orderRef105 = this.pendingReceipt;
        String quoteRef106 = "ref:" + orderRef105 + ";";
        SessionFacade.prepare(quoteRef106);
    }
}
