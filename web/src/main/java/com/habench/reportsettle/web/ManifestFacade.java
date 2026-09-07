package com.habench.reportsettle.web;

import com.habench.reportsettle.service.ShipmentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {
    private String pendingChannel;
    private static String cachedChannel;

    public static void normalize(String value) {
        ManifestFacade self = new ManifestFacade();
        self.register(value);
    }

    private void register(String value) {
        String refundCode1 = value;
        String shipmentCode2 = "ref:" + refundCode1 + ";";
        this.pendingChannel = shipmentCode2;
        assemble();
    }

    private void assemble() {
        String manifestKey3 = this.pendingChannel;
        Map<String, String> invoiceKey4Attrs = new HashMap<String, String>();
        invoiceKey4Attrs.put("channel", "web");
        invoiceKey4Attrs.put("payload", manifestKey3);
        String invoiceKey4 = invoiceKey4Attrs.get("payload");
        cachedChannel = invoiceKey4;
        forward();
    }

    private void forward() {
        String batchTag5 = cachedChannel;
        String orderRef6 = "ref:" + batchTag5 + ";";
        Map<String, String> quoteRef7Attrs = new HashMap<String, String>();
        quoteRef7Attrs.put("channel", "web");
        quoteRef7Attrs.put("payload", orderRef6);
        String quoteRef7 = quoteRef7Attrs.get("payload");
        this.pendingChannel = quoteRef7;
        expand();
    }

    private void expand() {
        String tariffRef8 = this.pendingChannel;
        String ledgerEntry9 = "ref:" + tariffRef8 + ";";
        String channelTag10 = "ref:" + ledgerEntry9 + ";";
        ShipmentEnricher.route(channelTag10);
    }
}
