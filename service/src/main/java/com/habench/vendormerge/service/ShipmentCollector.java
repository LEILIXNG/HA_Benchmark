package com.habench.vendormerge.service;

import com.habench.vendormerge.service.InvoiceBroker;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void reconcile(String value) {
        ShipmentCollector self = new ShipmentCollector();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        this.pendingCatalog = catalogKey102;
        register();
    }

    private void register() {
        String receiptKey103 = this.pendingCatalog;
        Map<String, String> accountRef104Attrs = new HashMap<String, String>();
        accountRef104Attrs.put("channel", "web");
        accountRef104Attrs.put("payload", receiptKey103);
        String accountRef104 = accountRef104Attrs.get("payload");
        cachedCatalog = accountRef104;
        enrich();
    }

    private void enrich() {
        String voucherRef105 = cachedCatalog;
        Map<String, String> paymentTag106Attrs = new HashMap<String, String>();
        paymentTag106Attrs.put("channel", "web");
        paymentTag106Attrs.put("payload", voucherRef105);
        String paymentTag106 = paymentTag106Attrs.get("payload");
        String refundCode107 = paymentTag106;
        InvoiceBroker.submit(refundCode107);
    }
}
