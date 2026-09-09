package com.habench.customerdispatch.service;

import com.habench.customerdispatch.dao.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {

    public static void submit(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        ReceiptNormalizer.forward(refundCode102);
    }
}
