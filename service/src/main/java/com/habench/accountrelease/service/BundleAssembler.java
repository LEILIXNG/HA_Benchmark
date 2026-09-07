package com.habench.accountrelease.service;

import com.habench.accountrelease.service.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {

    public static void prepare(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        String voucherRef102 = "ref:" + accountRef101 + ";";
        ManifestRepository.merge(voucherRef102);
    }
}
