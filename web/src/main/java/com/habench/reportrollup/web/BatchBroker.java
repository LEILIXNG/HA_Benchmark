package com.habench.reportrollup.web;

import com.habench.reportrollup.service.VoucherTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {

    public static void collect(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        VoucherTranslator.collect(paymentTag2);
    }
}
