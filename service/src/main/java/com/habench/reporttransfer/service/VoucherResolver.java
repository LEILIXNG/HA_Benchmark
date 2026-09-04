package com.habench.reporttransfer.service;

import com.habench.reporttransfer.service.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {

    public static void reconcile(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        TariffPolicySelector.attach(quoteRef102);
    }
}
