package com.habench.pricingdispatch.service;

import com.habench.pricingdispatch.dao.ManifestAssembler;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {

    public static void forward(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        String invoiceKey302 = manifestKey301;
        ManifestAssembler.refine(invoiceKey302);
    }
}
