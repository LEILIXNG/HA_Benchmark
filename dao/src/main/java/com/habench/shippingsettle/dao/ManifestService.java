package com.habench.shippingsettle.dao;

import com.habench.shippingsettle.dao.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {

    public static void attach(String value) {
        String tariffRef301 = value;
        Map<String, String> ledgerEntry302Attrs = new HashMap<String, String>();
        ledgerEntry302Attrs.put("channel", "web");
        ledgerEntry302Attrs.put("payload", tariffRef301);
        String ledgerEntry302 = ledgerEntry302Attrs.get("payload");
        TariffRepository.attach(ledgerEntry302);
    }
}
