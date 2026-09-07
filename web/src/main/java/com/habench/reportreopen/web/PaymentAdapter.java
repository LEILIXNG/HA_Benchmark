package com.habench.reportreopen.web;

import com.habench.reportreopen.service.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAdapter {

    public static void compose(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        BundleBuilder.submit(paymentTag102);
    }
}
