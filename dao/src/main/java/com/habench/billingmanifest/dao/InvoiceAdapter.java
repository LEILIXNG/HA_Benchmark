package com.habench.billingmanifest.dao;

import com.habench.billingmanifest.dao.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {

    public static void route(String value) {
        String voucherRef501 = "ref:" + value + ";";
        Map<String, String> paymentTag502Attrs = new HashMap<String, String>();
        paymentTag502Attrs.put("channel", "web");
        paymentTag502Attrs.put("payload", voucherRef501);
        String paymentTag502 = paymentTag502Attrs.get("payload");
        ChannelRepository.publish(paymentTag502);
    }
}
