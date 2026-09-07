package com.habench.billingclose.service;

import com.habench.billingclose.dao.ManifestBuilder;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {

    public static void assemble(String value) {
        Map<String, String> accountRef301Attrs = new HashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("payload", value);
        String accountRef301 = accountRef301Attrs.get("payload");
        String voucherRef302 = "ref:" + accountRef301 + ";";
        ManifestBuilder.translate(voucherRef302);
    }
}
