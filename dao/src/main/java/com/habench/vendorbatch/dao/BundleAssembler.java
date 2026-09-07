package com.habench.vendorbatch.dao;

import com.habench.vendorbatch.dao.LedgerFetcher;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {

    public static void reconcile(String value) {
        String paymentTag301 = value;
        Map<String, String> refundCode302Attrs = new HashMap<String, String>();
        refundCode302Attrs.put("channel", "web");
        refundCode302Attrs.put("payload", paymentTag301);
        String refundCode302 = refundCode302Attrs.get("payload");
        LedgerFetcher.submit(refundCode302);
    }
}
