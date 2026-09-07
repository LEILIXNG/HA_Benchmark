package com.habench.catalogposting.web;

import com.habench.catalogposting.service.ContractTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {

    public static void dispatch(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        ContractTranslator.expand(voucherRef1);
    }
}
