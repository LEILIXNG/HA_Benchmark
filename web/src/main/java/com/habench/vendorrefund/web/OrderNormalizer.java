package com.habench.vendorrefund.web;

import com.habench.vendorrefund.service.ChannelResolver;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {
    private String pendingShipment;
    private static String cachedShipment;

    public static void refine(String value) {
        OrderNormalizer self = new OrderNormalizer();
        self.expand(value);
    }

    private void expand(String value) {
        String quoteRef1 = "ref:" + value + ";";
        this.pendingShipment = quoteRef1;
        collect();
    }

    private void collect() {
        String tariffRef2 = this.pendingShipment;
        String ledgerEntry3 = "ref:" + tariffRef2 + ";";
        cachedShipment = ledgerEntry3;
        compose();
    }

    private void compose() {
        String channelTag4 = cachedShipment;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        ChannelResolver.expand(catalogKey5);
    }
}
