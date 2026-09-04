package com.habench.vendorissue.dao;

import com.habench.vendorissue.dao.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {
    private static String cachedPayment;

    public static void submit(String value) {
        Map<String, String> channelTag401Attrs = new HashMap<String, String>();
        channelTag401Attrs.put("channel", "web");
        channelTag401Attrs.put("payload", value);
        String channelTag401 = channelTag401Attrs.get("payload");
        cachedPayment = channelTag401;
        publish();
    }

    private static void publish() {
        String catalogKey402 = cachedPayment;
        String receiptKey403 = catalogKey402;
        Map<String, String> accountRef404Attrs = new HashMap<String, String>();
        accountRef404Attrs.put("channel", "web");
        accountRef404Attrs.put("payload", receiptKey403);
        String accountRef404 = accountRef404Attrs.get("payload");
        PaymentLoader.collect(accountRef404);
    }
}
