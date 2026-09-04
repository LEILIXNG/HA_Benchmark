package com.habench.shippingbind.web;

import com.habench.shippingbind.service.VoucherService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {

    public static void dispatch(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        VoucherService.collect(paymentTag101);
    }
}
