package com.habench.reportclose.web;

import com.habench.reportclose.service.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void expand(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = "ref:" + accountRef1 + ";";
        ManifestService.refine(voucherRef2);
    }
}
