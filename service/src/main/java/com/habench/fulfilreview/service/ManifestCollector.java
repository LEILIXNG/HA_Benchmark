package com.habench.fulfilreview.service;

import com.habench.fulfilreview.service.ChannelScreen;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {
    private static String cachedOrder;

    public static void submit(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        cachedOrder = accountRef201;
        reconcile();
    }

    private static void reconcile() {
        String voucherRef202 = cachedOrder;
        Map<String, String> paymentTag203Attrs = new HashMap<String, String>();
        paymentTag203Attrs.put("channel", "web");
        paymentTag203Attrs.put("payload", voucherRef202);
        String paymentTag203 = paymentTag203Attrs.get("payload");
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        cachedOrder = refundCode204;
        forward();
    }

    private static void forward() {
        String shipmentCode205 = cachedOrder;
        Map<String, String> manifestKey206Attrs = new HashMap<String, String>();
        manifestKey206Attrs.put("channel", "web");
        manifestKey206Attrs.put("payload", shipmentCode205);
        String manifestKey206 = manifestKey206Attrs.get("payload");
        ChannelScreen.route(manifestKey206);
    }
}
