package com.habench.shippingverify.service;

import com.habench.shippingverify.dao.CatalogFacade;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {
    private String pendingOrder;

    public static void refine(String value) {
        OrderResolver self = new OrderResolver();
        self.expand(value);
    }

    private void expand(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        this.pendingOrder = manifestKey102;
        merge();
    }

    private void merge() {
        String invoiceKey103 = this.pendingOrder;
        String batchTag104 = "ref:" + invoiceKey103 + ";";
        String orderRef105 = "ref:" + batchTag104 + ";";
        this.pendingOrder = orderRef105;
        register();
    }

    private void register() {
        String quoteRef106 = this.pendingOrder;
        String tariffRef107 = quoteRef106;
        Map<String, String> ledgerEntry108Attrs = new HashMap<String, String>();
        ledgerEntry108Attrs.put("channel", "web");
        ledgerEntry108Attrs.put("payload", tariffRef107);
        String ledgerEntry108 = ledgerEntry108Attrs.get("payload");
        CatalogFacade.translate(ledgerEntry108);
    }
}
