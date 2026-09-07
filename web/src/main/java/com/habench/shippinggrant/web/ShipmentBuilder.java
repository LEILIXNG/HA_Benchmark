package com.habench.shippinggrant.web;

import com.habench.shippinggrant.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void stage(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.attach(value);
    }

    private void attach(String value) {
        String shipmentCode1 = value;
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        cachedCatalog = manifestKey2;
        normalize();
    }

    private void normalize() {
        String invoiceKey3 = cachedCatalog;
        Map<String, String> batchTag4Attrs = new HashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("payload", invoiceKey3);
        String batchTag4 = batchTag4Attrs.get("payload");
        String orderRef5 = "ref:" + batchTag4 + ";";
        cachedCatalog = orderRef5;
        compose();
    }

    private void compose() {
        String quoteRef6 = cachedCatalog;
        String tariffRef7 = quoteRef6;
        cachedCatalog = tariffRef7;
        merge();
    }

    private void merge() {
        String ledgerEntry8 = cachedCatalog;
        String channelTag9 = ledgerEntry8;
        String catalogKey10 = channelTag9;
        this.pendingCatalog = catalogKey10;
        collect();
    }

    private void collect() {
        String receiptKey11 = this.pendingCatalog;
        Map<String, String> accountRef12Attrs = new HashMap<String, String>();
        accountRef12Attrs.put("channel", "web");
        accountRef12Attrs.put("payload", receiptKey11);
        String accountRef12 = accountRef12Attrs.get("payload");
        InvoiceResolver.normalize(accountRef12);
    }
}
