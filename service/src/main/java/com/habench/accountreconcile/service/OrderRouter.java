package com.habench.accountreconcile.service;

import com.habench.accountreconcile.dao.ChannelFacade;
import java.util.HashMap;
import java.util.Map;

public final class OrderRouter {

    public static void expand(String value) {
        String voucherRef101 = "ref:" + value + ";";
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        ChannelFacade.translate(paymentTag102);
    }
}
