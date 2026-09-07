package com.habench.accountposting.dao;

import com.habench.accountposting.dao.TariffExecutor;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private static String cachedTariff;

    public static void expand(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        String shipmentCode402 = refundCode401;
        cachedTariff = shipmentCode402;
        stage();
    }

    private static void stage() {
        String manifestKey403 = cachedTariff;
        String invoiceKey404 = manifestKey403;
        String batchTag405 = "ref:" + invoiceKey404 + ";";
        TariffExecutor.refine(batchTag405);
    }
}
