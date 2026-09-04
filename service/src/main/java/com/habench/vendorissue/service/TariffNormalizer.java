package com.habench.vendorissue.service;

import com.habench.vendorissue.dao.TariffTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {

    public static void compose(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        String refundCode302 = "ref:" + paymentTag301 + ";";
        TariffTranslator.submit(refundCode302);
    }
}
