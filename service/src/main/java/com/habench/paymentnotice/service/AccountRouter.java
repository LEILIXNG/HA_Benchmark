package com.habench.paymentnotice.service;

import com.habench.paymentnotice.dao.ContractService;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {

    public static void enrich(String value) {
        Map<String, String> accountRef301Attrs = new HashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("payload", value);
        String accountRef301 = accountRef301Attrs.get("payload");
        Map<String, String> voucherRef302Attrs = new HashMap<String, String>();
        voucherRef302Attrs.put("channel", "web");
        voucherRef302Attrs.put("payload", accountRef301);
        String voucherRef302 = voucherRef302Attrs.get("payload");
        ContractService.enrich(voucherRef302);
    }
}
