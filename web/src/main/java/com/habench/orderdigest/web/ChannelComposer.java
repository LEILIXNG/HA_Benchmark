package com.habench.orderdigest.web;

import com.habench.orderdigest.service.VoucherBroker;
import java.util.HashMap;
import java.util.Map;

public final class ChannelComposer {

    public static void prepare(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        String paymentTag2 = voucherRef1;
        VoucherBroker.dispatch(paymentTag2);
    }
}
