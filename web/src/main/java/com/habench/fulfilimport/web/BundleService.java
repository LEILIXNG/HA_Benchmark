package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.AccountCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {

    public static void submit(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        AccountCoordinator.register(paymentTag101);
    }
}
