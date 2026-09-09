package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.InvoiceComposer;
import java.util.HashMap;
import java.util.Map;

public final class QuoteResolver {
    private static String cachedAccount;

    public static void enrich(String value) {
        String voucherRef101 = value;
        String paymentTag102 = voucherRef101;
        cachedAccount = paymentTag102;
        resolve();
    }

    private static void resolve() {
        String refundCode103 = cachedAccount;
        Map<String, String> shipmentCode104Attrs = new HashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("payload", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get("payload");
        Map<String, String> manifestKey105Attrs = new HashMap<String, String>();
        manifestKey105Attrs.put("channel", "web");
        manifestKey105Attrs.put("payload", shipmentCode104);
        String manifestKey105 = manifestKey105Attrs.get("payload");
        InvoiceComposer.resolve(manifestKey105);
    }
}
