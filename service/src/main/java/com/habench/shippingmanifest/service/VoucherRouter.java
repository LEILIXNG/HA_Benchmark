package com.habench.shippingmanifest.service;

import com.habench.shippingmanifest.service.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void register(String value) {
        VoucherRouter self = new VoucherRouter();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        this.pendingShipment = shipmentCode101;
        collect();
    }

    private void collect() {
        String manifestKey102 = this.pendingShipment;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        Map<String, String> batchTag104Attrs = new HashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("payload", invoiceKey103);
        String batchTag104 = batchTag104Attrs.get("payload");
        cachedShipment = batchTag104;
        attach();
    }

    private void attach() {
        String orderRef105 = cachedShipment;
        Map<String, String> quoteRef106Attrs = new HashMap<String, String>();
        quoteRef106Attrs.put("channel", "web");
        quoteRef106Attrs.put("payload", orderRef105);
        String quoteRef106 = quoteRef106Attrs.get("payload");
        String tariffRef107 = "ref:" + quoteRef106 + ";";
        this.pendingShipment = tariffRef107;
        translate();
    }

    private void translate() {
        String ledgerEntry108 = this.pendingShipment;
        String channelTag109 = "ref:" + ledgerEntry108 + ";";
        SessionBuilder.refine(channelTag109);
    }
}
