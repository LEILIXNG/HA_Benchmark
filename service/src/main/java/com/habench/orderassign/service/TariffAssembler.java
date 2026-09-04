package com.habench.orderassign.service;

import com.habench.orderassign.dao.ManifestFacade;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {
    private static String cachedReceipt;

    public static void expand(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        cachedReceipt = refundCode102;
        compose();
    }

    private static void compose() {
        String shipmentCode103 = cachedReceipt;
        String manifestKey104 = "ref:" + shipmentCode103 + ";";
        ManifestFacade.enrich(manifestKey104);
    }
}
