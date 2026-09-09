package com.habench.catalogdispatch.service;

import com.habench.catalogdispatch.dao.TariffComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAssembler {
    private static String cachedChannel;

    public static void resolve(String value) {
        String voucherRef201 = "ref:" + value + ";";
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        cachedChannel = paymentTag202;
        enrich();
    }

    private static void enrich() {
        String refundCode203 = cachedChannel;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        TariffComposer.dispatch(shipmentCode204);
    }
}
