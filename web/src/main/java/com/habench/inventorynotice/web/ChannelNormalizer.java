package com.habench.inventorynotice.web;

import com.habench.inventorynotice.service.AccountAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {

    public static void merge(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        AccountAssembler.attach(ledgerEntry1);
    }
}
