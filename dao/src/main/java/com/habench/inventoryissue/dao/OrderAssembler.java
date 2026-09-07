package com.habench.inventoryissue.dao;

import com.habench.inventoryissue.dao.ManifestLoader;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {

    public static void translate(String value) {
        Map<String, String> ledgerEntry501Attrs = new HashMap<String, String>();
        ledgerEntry501Attrs.put("channel", "web");
        ledgerEntry501Attrs.put("payload", value);
        String ledgerEntry501 = ledgerEntry501Attrs.get("payload");
        Map<String, String> channelTag502Attrs = new HashMap<String, String>();
        channelTag502Attrs.put("channel", "web");
        channelTag502Attrs.put("payload", ledgerEntry501);
        String channelTag502 = channelTag502Attrs.get("payload");
        ManifestLoader.register(channelTag502);
    }
}
