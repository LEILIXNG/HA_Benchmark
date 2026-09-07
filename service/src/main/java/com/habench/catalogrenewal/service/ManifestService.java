package com.habench.catalogrenewal.service;

import com.habench.catalogrenewal.service.BundleCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {
    private static String cachedContract;

    public static void assemble(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        String quoteRef302 = orderRef301;
        cachedContract = quoteRef302;
        refine();
    }

    private static void refine() {
        String tariffRef303 = cachedContract;
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        String channelTag305 = ledgerEntry304;
        BundleCoordinator.dispatch(channelTag305);
    }
}
