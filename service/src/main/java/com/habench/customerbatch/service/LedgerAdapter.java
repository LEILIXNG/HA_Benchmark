package com.habench.customerbatch.service;

import com.habench.customerbatch.dao.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAdapter {
    private static String cachedBatch;

    public static void assemble(String value) {
        String batchTag401 = value;
        cachedBatch = batchTag401;
        submit();
    }

    private static void submit() {
        String orderRef402 = cachedBatch;
        Map<String, String> quoteRef403Attrs = new HashMap<String, String>();
        quoteRef403Attrs.put("channel", "web");
        quoteRef403Attrs.put("payload", orderRef402);
        String quoteRef403 = quoteRef403Attrs.get("payload");
        Map<String, String> tariffRef404Attrs = new HashMap<String, String>();
        tariffRef404Attrs.put("channel", "web");
        tariffRef404Attrs.put("payload", quoteRef403);
        String tariffRef404 = tariffRef404Attrs.get("payload");
        ShipmentBuilder.assemble(tariffRef404);
    }
}
