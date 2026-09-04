package com.habench.ordermerge.service;

import com.habench.ordermerge.service.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {
    private static String cachedTariff;

    public static void collect(String value) {
        String shipmentCode101 = value;
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        cachedTariff = manifestKey102;
        forward();
    }

    private static void forward() {
        String invoiceKey103 = cachedTariff;
        String batchTag104 = "ref:" + invoiceKey103 + ";";
        cachedTariff = batchTag104;
        translate();
    }

    private static void translate() {
        String orderRef105 = cachedTariff;
        String quoteRef106 = orderRef105;
        TariffRepository.register(quoteRef106);
    }
}
