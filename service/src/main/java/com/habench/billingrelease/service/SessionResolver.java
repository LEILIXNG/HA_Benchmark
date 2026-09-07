package com.habench.billingrelease.service;

import com.habench.billingrelease.service.ChannelStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {
    private String pendingShipment;
    private static String cachedShipment;

    public static void expand(String value) {
        SessionResolver self = new SessionResolver();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        cachedShipment = shipmentCode102;
        refine();
    }

    private void refine() {
        String manifestKey103 = cachedShipment;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        this.pendingShipment = invoiceKey104;
        collect();
    }

    private void collect() {
        String batchTag105 = this.pendingShipment;
        String orderRef106 = batchTag105;
        Map<String, String> quoteRef107Attrs = new HashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("payload", orderRef106);
        String quoteRef107 = quoteRef107Attrs.get("payload");
        ChannelStrategySelector.attach(quoteRef107);
    }
}
