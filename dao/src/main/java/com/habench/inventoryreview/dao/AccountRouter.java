package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {

    public static void attach(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        String ledgerEntry402 = "ref:" + tariffRef401 + ";";
        ManifestRepository.stage(ledgerEntry402);
    }
}
