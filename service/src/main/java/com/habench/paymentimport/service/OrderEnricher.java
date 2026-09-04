package com.habench.paymentimport.service;

import com.habench.paymentimport.service.CatalogStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderEnricher {
    private String pendingShipment;
    private static String cachedShipment;

    public static void forward(String value) {
        OrderEnricher self = new OrderEnricher();
        self.stage(value);
    }

    private void stage(String value) {
        String refundCode101 = "ref:" + value + ";";
        cachedShipment = refundCode101;
        translate();
    }

    private void translate() {
        String shipmentCode102 = cachedShipment;
        String manifestKey103 = shipmentCode102;
        this.pendingShipment = manifestKey103;
        expand();
    }

    private void expand() {
        String invoiceKey104 = this.pendingShipment;
        Map<String, String> batchTag105Attrs = new HashMap<String, String>();
        batchTag105Attrs.put("channel", "web");
        batchTag105Attrs.put("payload", invoiceKey104);
        String batchTag105 = batchTag105Attrs.get("payload");
        cachedShipment = batchTag105;
        register();
    }

    private void register() {
        String orderRef106 = cachedShipment;
        Map<String, String> quoteRef107Attrs = new HashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("payload", orderRef106);
        String quoteRef107 = quoteRef107Attrs.get("payload");
        String tariffRef108 = quoteRef107;
        CatalogStrategySelector.refine(tariffRef108);
    }
}
