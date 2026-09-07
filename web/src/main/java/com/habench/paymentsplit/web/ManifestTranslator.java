package com.habench.paymentsplit.web;

import com.habench.paymentsplit.service.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {
    private static String cachedRefund;

    public static void publish(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        cachedRefund = batchTag301;
        merge();
    }

    private static void merge() {
        String orderRef302 = cachedRefund;
        String quoteRef303 = "ref:" + orderRef302 + ";";
        cachedRefund = quoteRef303;
        attach();
    }

    private static void attach() {
        String tariffRef304 = cachedRefund;
        String ledgerEntry305 = "ref:" + tariffRef304 + ";";
        String channelTag306 = "ref:" + ledgerEntry305 + ";";
        VoucherAdapter.prepare(channelTag306);
    }
}
