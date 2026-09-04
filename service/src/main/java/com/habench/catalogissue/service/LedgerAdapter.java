package com.habench.catalogissue.service;

import com.habench.catalogissue.dao.OrderAdapter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAdapter {
    private static String cachedTariff;

    public static void resolve(String value) {
        Map<String, String> channelTag401Attrs = new HashMap<String, String>();
        channelTag401Attrs.put("channel", "web");
        channelTag401Attrs.put("payload", value);
        String channelTag401 = channelTag401Attrs.get("payload");
        Map<String, String> catalogKey402Attrs = new HashMap<String, String>();
        catalogKey402Attrs.put("channel", "web");
        catalogKey402Attrs.put("payload", channelTag401);
        String catalogKey402 = catalogKey402Attrs.get("payload");
        cachedTariff = catalogKey402;
        expand();
    }

    private static void expand() {
        String receiptKey403 = cachedTariff;
        Map<String, String> accountRef404Attrs = new HashMap<String, String>();
        accountRef404Attrs.put("channel", "web");
        accountRef404Attrs.put("payload", receiptKey403);
        String accountRef404 = accountRef404Attrs.get("payload");
        String voucherRef405 = accountRef404;
        OrderAdapter.publish(voucherRef405);
    }
}
