package com.habench.vendormerge.service;

import com.habench.vendormerge.service.AccountFilter;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {

    public static void dispatch(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        String refundCode302 = "ref:" + paymentTag301 + ";";
        AccountFilter.merge(refundCode302);
    }
}
