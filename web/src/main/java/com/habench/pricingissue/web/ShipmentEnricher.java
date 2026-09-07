package com.habench.pricingissue.web;

import com.habench.pricingissue.service.CatalogService;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private String pendingLedger;
    private static String cachedLedger;

    public static void publish(String value) {
        ShipmentEnricher self = new ShipmentEnricher();
        self.register(value);
    }

    private void register(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingLedger = channelTag1;
        prepare();
    }

    private void prepare() {
        String catalogKey2 = this.pendingLedger;
        String receiptKey3 = "ref:" + catalogKey2 + ";";
        cachedLedger = receiptKey3;
        enrich();
    }

    private void enrich() {
        String accountRef4 = cachedLedger;
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        CatalogService.forward(voucherRef5);
    }
}
