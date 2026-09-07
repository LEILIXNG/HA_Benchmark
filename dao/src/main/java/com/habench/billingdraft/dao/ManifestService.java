package com.habench.billingdraft.dao;

import com.habench.billingdraft.dao.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {

    public static void attach(String value) {
        Map<String, String> voucherRef501Attrs = new HashMap<String, String>();
        voucherRef501Attrs.put("channel", "web");
        voucherRef501Attrs.put("payload", value);
        String voucherRef501 = voucherRef501Attrs.get("payload");
        String paymentTag502 = voucherRef501;
        ChannelExecutor.publish(paymentTag502);
    }
}
