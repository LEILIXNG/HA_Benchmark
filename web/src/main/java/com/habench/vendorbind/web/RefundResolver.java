package com.habench.vendorbind.web;

import com.habench.vendorbind.service.VoucherNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class RefundResolver {

    public static void register(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        VoucherNormalizer.refine(catalogKey2);
    }
}
