package com.habench.billingclose.dao;

import com.habench.billingclose.dao.BatchFilter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBuilder {

    public static void translate(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        String ledgerEntry402 = tariffRef401;
        BatchFilter.assemble(ledgerEntry402);
    }
}
