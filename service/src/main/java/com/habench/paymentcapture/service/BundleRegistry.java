package com.habench.paymentcapture.service;

import com.habench.paymentcapture.dao.VoucherRouter;
import java.util.HashMap;
import java.util.Map;

public final class BundleRegistry {

    public static void normalize(String value) {
        String orderRef201 = value;
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        VoucherRouter.assemble(quoteRef202);
    }
}
