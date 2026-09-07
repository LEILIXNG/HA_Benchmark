package com.habench.vendorbind.service;

import com.habench.vendorbind.dao.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {
    private static String cachedRefund;

    public static void translate(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        cachedRefund = orderRef101;
        merge();
    }

    private static void merge() {
        String quoteRef102 = cachedRefund;
        String tariffRef103 = quoteRef102;
        cachedRefund = tariffRef103;
        forward();
    }

    private static void forward() {
        String ledgerEntry104 = cachedRefund;
        String channelTag105 = ledgerEntry104;
        BatchTranslator.stage(channelTag105);
    }
}
