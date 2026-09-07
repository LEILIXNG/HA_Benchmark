package com.habench.vendorsync.service;

import com.habench.vendorsync.service.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void dispatch(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        AccountPolicySelector.reconcile(voucherRef202);
    }
}
