package com.habench.vendorexport.web;

import com.habench.vendorexport.web.BatchPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {
    private String pendingBundle;
    private static String cachedBundle;

    public static void assemble(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.publish(value);
    }

    private void publish(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        this.pendingBundle = batchTag2;
        expand();
    }

    private void expand() {
        String orderRef3 = this.pendingBundle;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        String tariffRef5 = quoteRef4;
        cachedBundle = tariffRef5;
        normalize();
    }

    private void normalize() {
        String ledgerEntry6 = cachedBundle;
        String channelTag7 = ledgerEntry6;
        cachedBundle = channelTag7;
        translate();
    }

    private void translate() {
        String catalogKey8 = cachedBundle;
        String receiptKey9 = catalogKey8;
        Map<String, String> accountRef10Attrs = new HashMap<String, String>();
        accountRef10Attrs.put("channel", "web");
        accountRef10Attrs.put("payload", receiptKey9);
        String accountRef10 = accountRef10Attrs.get("payload");
        BatchPlanSelector.merge(accountRef10);
    }
}
