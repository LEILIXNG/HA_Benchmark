package com.habench.pricingapprove.service;

import com.habench.pricingapprove.dao.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void submit(String value) {
        BatchEnricher self = new BatchEnricher();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        cachedCatalog = manifestKey202;
        merge();
    }

    private void merge() {
        String invoiceKey203 = cachedCatalog;
        Map<String, String> batchTag204Attrs = new HashMap<String, String>();
        batchTag204Attrs.put("channel", "web");
        batchTag204Attrs.put("payload", invoiceKey203);
        String batchTag204 = batchTag204Attrs.get("payload");
        String orderRef205 = "ref:" + batchTag204 + ";";
        this.pendingCatalog = orderRef205;
        normalize();
    }

    private void normalize() {
        String quoteRef206 = this.pendingCatalog;
        String tariffRef207 = "ref:" + quoteRef206 + ";";
        Map<String, String> ledgerEntry208Attrs = new HashMap<String, String>();
        ledgerEntry208Attrs.put("channel", "web");
        ledgerEntry208Attrs.put("payload", tariffRef207);
        String ledgerEntry208 = ledgerEntry208Attrs.get("payload");
        ManifestRouter.publish(ledgerEntry208);
    }
}
