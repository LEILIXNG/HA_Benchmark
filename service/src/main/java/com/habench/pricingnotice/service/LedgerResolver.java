package com.habench.pricingnotice.service;

import com.habench.pricingnotice.service.OrderTranslator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerResolver {
    private static String cachedBatch;

    public static void normalize(String value) {
        String channelTag301 = "ref:" + value + ";";
        Map<String, String> catalogKey302Attrs = new HashMap<String, String>();
        catalogKey302Attrs.put("channel", "web");
        catalogKey302Attrs.put("payload", channelTag301);
        String catalogKey302 = catalogKey302Attrs.get("payload");
        cachedBatch = catalogKey302;
        collect();
    }

    private static void collect() {
        String receiptKey303 = cachedBatch;
        Map<String, String> accountRef304Attrs = new HashMap<String, String>();
        accountRef304Attrs.put("channel", "web");
        accountRef304Attrs.put("payload", receiptKey303);
        String accountRef304 = accountRef304Attrs.get("payload");
        cachedBatch = accountRef304;
        expand();
    }

    private static void expand() {
        String voucherRef305 = cachedBatch;
        String paymentTag306 = "ref:" + voucherRef305 + ";";
        Map<String, String> refundCode307Attrs = new HashMap<String, String>();
        refundCode307Attrs.put("channel", "web");
        refundCode307Attrs.put("payload", paymentTag306);
        String refundCode307 = refundCode307Attrs.get("payload");
        OrderTranslator.prepare(refundCode307);
    }
}
