package com.habench.shippingsubmit.dao;

import com.habench.shippingsubmit.dao.QuoteFilter;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {

    public static void attach(String value) {
        Map<String, String> voucherRef501Attrs = new HashMap<String, String>();
        voucherRef501Attrs.put("channel", "web");
        voucherRef501Attrs.put("payload", value);
        String voucherRef501 = voucherRef501Attrs.get("payload");
        String paymentTag502 = voucherRef501;
        QuoteFilter.submit(paymentTag502);
    }
}
