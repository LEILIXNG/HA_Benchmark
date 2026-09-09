package com.habench.fulfilexport.web;

import com.habench.fulfilexport.web.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleEnricher {
    private String pendingBundle;

    public static void collect(String value) {
        BundleEnricher self = new BundleEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        this.pendingBundle = manifestKey2;
        translate();
    }

    private void translate() {
        String invoiceKey3 = this.pendingBundle;
        String batchTag4 = invoiceKey3;
        QuotePlanSelector.expand(batchTag4);
    }
}
