package com.habench.reportsettle.service;

import com.habench.reportsettle.service.VoucherValidator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private String pendingChannel;
    private static String cachedChannel;

    public static void route(String value) {
        ShipmentEnricher self = new ShipmentEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String catalogKey101 = "ref:" + value + ";";
        String receiptKey102 = catalogKey101;
        cachedChannel = receiptKey102;
        assemble();
    }

    private void assemble() {
        String accountRef103 = cachedChannel;
        Map<String, String> voucherRef104Attrs = new HashMap<String, String>();
        voucherRef104Attrs.put("channel", "web");
        voucherRef104Attrs.put("payload", accountRef103);
        String voucherRef104 = voucherRef104Attrs.get("payload");
        String paymentTag105 = voucherRef104;
        this.pendingChannel = paymentTag105;
        register();
    }

    private void register() {
        String refundCode106 = this.pendingChannel;
        Map<String, String> shipmentCode107Attrs = new HashMap<String, String>();
        shipmentCode107Attrs.put("channel", "web");
        shipmentCode107Attrs.put("payload", refundCode106);
        String shipmentCode107 = shipmentCode107Attrs.get("payload");
        String manifestKey108 = "ref:" + shipmentCode107 + ";";
        VoucherValidator.enrich(manifestKey108);
    }
}
