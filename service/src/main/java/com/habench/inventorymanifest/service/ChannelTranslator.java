package com.habench.inventorymanifest.service;

import com.habench.inventorymanifest.service.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {

    public static void forward(String value) {
        String quoteRef101 = "ref:" + value + ";";
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        ManifestService.publish(tariffRef102);
    }
}
