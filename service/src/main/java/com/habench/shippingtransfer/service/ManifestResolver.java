package com.habench.shippingtransfer.service;

import com.habench.shippingtransfer.dao.VoucherRouter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {

    public static void enrich(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        String ledgerEntry302 = tariffRef301;
        VoucherRouter.stage(ledgerEntry302);
    }
}
