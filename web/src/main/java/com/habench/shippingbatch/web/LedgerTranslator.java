package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void prepare(String value) {
        LedgerTranslator self = new LedgerTranslator();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        this.pendingCatalog = voucherRef1;
        translate();
    }

    private void translate() {
        String paymentTag2 = this.pendingCatalog;
        String refundCode3 = "ref:" + paymentTag2 + ";";
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        cachedCatalog = shipmentCode4;
        publish();
    }

    private void publish() {
        String manifestKey5 = cachedCatalog;
        String invoiceKey6 = "ref:" + manifestKey5 + ";";
        cachedCatalog = invoiceKey6;
        enrich();
    }

    private void enrich() {
        String batchTag7 = cachedCatalog;
        Map<String, String> orderRef8Attrs = new HashMap<String, String>();
        orderRef8Attrs.put("channel", "web");
        orderRef8Attrs.put("payload", batchTag7);
        String orderRef8 = orderRef8Attrs.get("payload");
        String quoteRef9 = orderRef8;
        ShipmentPlanSelector.dispatch(quoteRef9);
    }
}
