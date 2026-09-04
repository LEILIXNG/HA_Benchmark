package com.habench.accountdraft.dao;

import com.habench.accountdraft.dao.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private static String cachedManifest;

    public static void route(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        cachedManifest = orderRef301;
        compose();
    }

    private static void compose() {
        String quoteRef302 = cachedManifest;
        String tariffRef303 = quoteRef302;
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        cachedManifest = ledgerEntry304;
        prepare();
    }

    private static void prepare() {
        String channelTag305 = cachedManifest;
        String catalogKey306 = "ref:" + channelTag305 + ";";
        String receiptKey307 = catalogKey306;
        ReceiptRegistry.compose(receiptKey307);
    }
}
