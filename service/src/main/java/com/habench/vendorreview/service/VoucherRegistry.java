package com.habench.vendorreview.service;

import com.habench.vendorreview.dao.TariffNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRegistry {

    public static void assemble(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        Map<String, String> channelTag302Attrs = new HashMap<String, String>();
        channelTag302Attrs.put("channel", "web");
        channelTag302Attrs.put("payload", ledgerEntry301);
        String channelTag302 = channelTag302Attrs.get("payload");
        TariffNormalizer.submit(channelTag302);
    }
}
