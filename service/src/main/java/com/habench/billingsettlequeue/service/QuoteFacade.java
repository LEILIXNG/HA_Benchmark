package com.habench.billingsettlequeue.service;

import com.habench.billingsettlequeue.dao.RefundEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {
    private static String cachedTariff;

    public static void forward(String value) {
        Map<String, String> shipmentCode401Attrs = new HashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("payload", value);
        String shipmentCode401 = shipmentCode401Attrs.get("payload");
        cachedTariff = shipmentCode401;
        refine();
    }

    private static void refine() {
        String manifestKey402 = cachedTariff;
        String invoiceKey403 = manifestKey402;
        Map<String, String> batchTag404Attrs = new HashMap<String, String>();
        batchTag404Attrs.put("channel", "web");
        batchTag404Attrs.put("payload", invoiceKey403);
        String batchTag404 = batchTag404Attrs.get("payload");
        RefundEnricher.assemble(batchTag404);
    }
}
