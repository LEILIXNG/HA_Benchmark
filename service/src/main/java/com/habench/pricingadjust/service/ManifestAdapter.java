package com.habench.pricingadjust.service;

import com.habench.pricingadjust.service.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {

    public static void assemble(String value) {
        String catalogKey301 = "ref:" + value + ";";
        Map<String, String> receiptKey302Attrs = new HashMap<String, String>();
        receiptKey302Attrs.put("channel", "web");
        receiptKey302Attrs.put("payload", catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get("payload");
        ContractRepository.reconcile(receiptKey302);
    }
}
