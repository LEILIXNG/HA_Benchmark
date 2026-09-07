package com.habench.customerrenewal.web;

import com.habench.customerrenewal.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {
    private String pendingQuote;
    private static String cachedQuote;

    public static void stage(String value) {
        InvoiceComposer self = new InvoiceComposer();
        self.register(value);
    }

    private void register(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        cachedQuote = shipmentCode101;
        translate();
    }

    private void translate() {
        String manifestKey102 = cachedQuote;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        String batchTag104 = "ref:" + invoiceKey103 + ";";
        this.pendingQuote = batchTag104;
        compose();
    }

    private void compose() {
        String orderRef105 = this.pendingQuote;
        String quoteRef106 = "ref:" + orderRef105 + ";";
        String tariffRef107 = "ref:" + quoteRef106 + ";";
        this.pendingQuote = tariffRef107;
        publish();
    }

    private void publish() {
        String ledgerEntry108 = this.pendingQuote;
        Map<String, String> channelTag109Attrs = new HashMap<String, String>();
        channelTag109Attrs.put("channel", "web");
        channelTag109Attrs.put("payload", ledgerEntry108);
        String channelTag109 = channelTag109Attrs.get("payload");
        Map<String, String> catalogKey110Attrs = new HashMap<String, String>();
        catalogKey110Attrs.put("channel", "web");
        catalogKey110Attrs.put("payload", channelTag109);
        String catalogKey110 = catalogKey110Attrs.get("payload");
        ShipmentBuilder.resolve(catalogKey110);
    }
}
