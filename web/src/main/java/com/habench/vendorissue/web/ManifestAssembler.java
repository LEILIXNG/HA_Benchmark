package com.habench.vendorissue.web;

import com.habench.vendorissue.web.VoucherBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {

    public static void collect(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        VoucherBuilder.enrich(catalogKey101);
    }
}
