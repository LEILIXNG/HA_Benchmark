package com.habench.customerreview.web;

import com.habench.customerreview.service.SessionAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {

    public static void route(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        SessionAdapter.submit(paymentTag201);
    }
}
