package com.habench.customercapture.web;

import com.habench.customercapture.web.VoucherNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {

    public static void merge(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        VoucherNormalizer.publish(batchTag1);
    }
}
