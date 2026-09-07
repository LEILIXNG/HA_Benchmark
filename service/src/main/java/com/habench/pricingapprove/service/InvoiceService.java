package com.habench.pricingapprove.service;

import com.habench.pricingapprove.service.CatalogExecutor;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void translate(String value) {
        InvoiceService self = new InvoiceService();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode201 = value;
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        cachedCatalog = manifestKey202;
        collect();
    }

    private void collect() {
        String invoiceKey203 = cachedCatalog;
        Map<String, String> batchTag204Attrs = new HashMap<String, String>();
        batchTag204Attrs.put("channel", "web");
        batchTag204Attrs.put("payload", invoiceKey203);
        String batchTag204 = batchTag204Attrs.get("payload");
        this.pendingCatalog = batchTag204;
        forward();
    }

    private void forward() {
        String orderRef205 = this.pendingCatalog;
        String quoteRef206 = "ref:" + orderRef205 + ";";
        Map<String, String> tariffRef207Attrs = new HashMap<String, String>();
        tariffRef207Attrs.put("channel", "web");
        tariffRef207Attrs.put("payload", quoteRef206);
        String tariffRef207 = tariffRef207Attrs.get("payload");
        CatalogExecutor.dispatch(tariffRef207);
    }
}
