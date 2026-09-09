package com.habench.accountreview.web;

import com.habench.accountreview.web.SessionFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {

    public static void translate(String value) {
        String voucherRef1 = value;
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        SessionFacade.expand(paymentTag2);
    }
}
