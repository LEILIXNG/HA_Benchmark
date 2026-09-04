package com.habench.accountsettle.dao;

import com.habench.accountsettle.dao.VoucherPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {

    public static void register(String value) {
        String channelTag201 = value;
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        VoucherPolicySelector.reconcile(catalogKey202);
    }
}
