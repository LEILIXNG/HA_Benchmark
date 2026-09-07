package com.habench.shippingdigest.service;

import com.habench.shippingdigest.service.LedgerRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {

    public static void resolve(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        String catalogKey102 = "ref:" + channelTag101 + ";";
        LedgerRepository.dispatch(catalogKey102);
    }
}
