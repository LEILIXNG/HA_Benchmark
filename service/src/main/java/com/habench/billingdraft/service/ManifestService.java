package com.habench.billingdraft.service;

import com.habench.billingdraft.service.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {

    public static void attach(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = voucherRef201;
        ChannelExecutor.publish(paymentTag202);
    }
}
