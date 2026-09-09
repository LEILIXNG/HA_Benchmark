package com.habench.pricingmanifest.dao;

import com.habench.pricingmanifest.dao.TariffNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingQuote;

    public static void compose(String value) {
        VoucherRouter self = new VoucherRouter();
        self.merge(value);
    }

    private void merge(String value) {
        String refundCode401 = value;
        this.pendingQuote = refundCode401;
        prepare();
    }

    private void prepare() {
        String shipmentCode402 = this.pendingQuote;
        Map<String, String> manifestKey403Attrs = new HashMap<String, String>();
        manifestKey403Attrs.put("channel", "web");
        manifestKey403Attrs.put("payload", shipmentCode402);
        String manifestKey403 = manifestKey403Attrs.get("payload");
        TariffNormalizer.refine(manifestKey403);
    }
}
