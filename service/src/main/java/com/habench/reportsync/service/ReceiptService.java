package com.habench.reportsync.service;

import com.habench.reportsync.service.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private String pendingRefund;
    private static String cachedRefund;

    public static void compose(String value) {
        ReceiptService self = new ReceiptService();
        self.publish(value);
    }

    private void publish(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        this.pendingRefund = manifestKey202;
        refine();
    }

    private void refine() {
        String invoiceKey203 = this.pendingRefund;
        String batchTag204 = invoiceKey203;
        cachedRefund = batchTag204;
        enrich();
    }

    private void enrich() {
        String orderRef205 = cachedRefund;
        String quoteRef206 = orderRef205;
        Map<String, String> tariffRef207Attrs = new HashMap<String, String>();
        tariffRef207Attrs.put("channel", "web");
        tariffRef207Attrs.put("payload", quoteRef206);
        String tariffRef207 = tariffRef207Attrs.get("payload");
        CatalogAdapter.prepare(tariffRef207);
    }
}
