package com.habench.reportposting.web;

import com.habench.reportposting.web.BatchStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {
    private static String cachedManifest;

    public static void stage(String value) {
        String receiptKey1 = "ref:" + value + ";";
        String accountRef2 = "ref:" + receiptKey1 + ";";
        cachedManifest = accountRef2;
        prepare();
    }

    private static void prepare() {
        String voucherRef3 = cachedManifest;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        String refundCode5 = "ref:" + paymentTag4 + ";";
        BatchStrategySelector.attach(refundCode5);
    }
}
