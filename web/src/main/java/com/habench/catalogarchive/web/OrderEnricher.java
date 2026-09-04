package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class OrderEnricher {
    private String pendingShipment;
    private static String cachedShipment;

    public static void enrich(String value) {
        OrderEnricher self = new OrderEnricher();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        this.pendingShipment = catalogKey2;
        forward();
    }

    private void forward() {
        String receiptKey3 = this.pendingShipment;
        String accountRef4 = receiptKey3;
        String voucherRef5 = accountRef4;
        this.pendingShipment = voucherRef5;
        stage();
    }

    private void stage() {
        String paymentTag6 = this.pendingShipment;
        Map<String, String> refundCode7Attrs = new HashMap<String, String>();
        refundCode7Attrs.put("channel", "web");
        refundCode7Attrs.put("payload", paymentTag6);
        String refundCode7 = refundCode7Attrs.get("payload");
        cachedShipment = refundCode7;
        collect();
    }

    private void collect() {
        String shipmentCode8 = cachedShipment;
        String manifestKey9 = shipmentCode8;
        BundleAdapter.translate(manifestKey9);
    }
}
