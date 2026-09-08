package com.habench.customerapprove.service;

import com.habench.customerapprove.service.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {
    private static String cachedOrder;

    public static void assemble(String value) {
        String quoteRef301 = value;
        String tariffRef302 = quoteRef301;
        cachedOrder = tariffRef302;
        dispatch();
    }

    private static void dispatch() {
        String ledgerEntry303 = cachedOrder;
        Map<String, String> channelTag304Attrs = new HashMap<String, String>();
        channelTag304Attrs.put("channel", "web");
        channelTag304Attrs.put("payload", ledgerEntry303);
        String channelTag304 = channelTag304Attrs.get("payload");
        BatchTranslator.compose(channelTag304);
    }
}
