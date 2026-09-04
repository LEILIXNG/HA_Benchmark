package com.habench.customerdispatch.dao;

import com.habench.customerdispatch.dao.CatalogNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {

    public static void submit(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        Map<String, String> ledgerEntry302Attrs = new HashMap<String, String>();
        ledgerEntry302Attrs.put("channel", "web");
        ledgerEntry302Attrs.put("payload", tariffRef301);
        String ledgerEntry302 = ledgerEntry302Attrs.get("payload");
        CatalogNormalizer.merge(ledgerEntry302);
    }
}
