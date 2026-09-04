package com.habench.reportreview.service;

import com.habench.reportreview.service.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void translate(String value) {
        String ledgerEntry301 = value;
        Map<String, String> channelTag302Attrs = new HashMap<String, String>();
        channelTag302Attrs.put("channel", "web");
        channelTag302Attrs.put("payload", ledgerEntry301);
        String channelTag302 = channelTag302Attrs.get("payload");
        BundleRepository.normalize(channelTag302);
    }
}
