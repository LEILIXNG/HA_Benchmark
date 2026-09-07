package com.habench.vendorgrant.service;

import com.habench.vendorgrant.dao.QuoteNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {
    private String pendingOrder;
    private static String cachedOrder;

    public static void expand(String value) {
        BundleAssembler self = new BundleAssembler();
        self.publish(value);
    }

    private void publish(String value) {
        String refundCode101 = "ref:" + value + ";";
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        this.pendingOrder = shipmentCode102;
        normalize();
    }

    private void normalize() {
        String manifestKey103 = this.pendingOrder;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        cachedOrder = invoiceKey104;
        resolve();
    }

    private void resolve() {
        String batchTag105 = cachedOrder;
        String orderRef106 = batchTag105;
        cachedOrder = orderRef106;
        refine();
    }

    private void refine() {
        String quoteRef107 = cachedOrder;
        Map<String, String> tariffRef108Attrs = new HashMap<String, String>();
        tariffRef108Attrs.put("channel", "web");
        tariffRef108Attrs.put("payload", quoteRef107);
        String tariffRef108 = tariffRef108Attrs.get("payload");
        Map<String, String> ledgerEntry109Attrs = new HashMap<String, String>();
        ledgerEntry109Attrs.put("channel", "web");
        ledgerEntry109Attrs.put("payload", tariffRef108);
        String ledgerEntry109 = ledgerEntry109Attrs.get("payload");
        QuoteNormalizer.route(ledgerEntry109);
    }
}
