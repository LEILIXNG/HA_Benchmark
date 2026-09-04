package com.habench.paymentnotice.web;

import com.habench.paymentnotice.web.TariffResolver;
import java.util.HashMap;
import java.util.Map;

public final class OrderRouter {

    public static void submit(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        TariffResolver.assemble(refundCode101);
    }
}
