package com.habench.shippingmanifest.web;

import com.habench.shippingmanifest.service.VoucherRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {
    private static String cachedShipment;

    public static void assemble(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        cachedShipment = tariffRef2;
        collect();
    }

    private static void collect() {
        String ledgerEntry3 = cachedShipment;
        String channelTag4 = ledgerEntry3;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        VoucherRouter.register(catalogKey5);
    }
}
