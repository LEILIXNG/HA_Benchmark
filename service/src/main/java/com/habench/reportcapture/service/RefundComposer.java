package com.habench.reportcapture.service;

import com.habench.reportcapture.service.VoucherEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {
    private static String cachedVoucher;

    public static void expand(String value) {
        String batchTag301 = value;
        String orderRef302 = "ref:" + batchTag301 + ";";
        cachedVoucher = orderRef302;
        stage();
    }

    private static void stage() {
        String quoteRef303 = cachedVoucher;
        String tariffRef304 = quoteRef303;
        Map<String, String> ledgerEntry305Attrs = new HashMap<String, String>();
        ledgerEntry305Attrs.put("channel", "web");
        ledgerEntry305Attrs.put("payload", tariffRef304);
        String ledgerEntry305 = ledgerEntry305Attrs.get("payload");
        VoucherEvaluator.collect(ledgerEntry305);
    }
}
