package com.habench.orderissue.web;

import com.habench.orderissue.web.VoucherTranslator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogComposer {

    public static void stage(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        VoucherTranslator.attach(refundCode2);
    }
}
