package com.habench.reportbatch.web;

import com.habench.reportbatch.service.AccountRegistry;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {
    private String pendingBundle;

    public static void expand(String value) {
        BundleTranslator self = new BundleTranslator();
        self.publish(value);
    }

    private void publish(String value) {
        String tariffRef101 = value;
        this.pendingBundle = tariffRef101;
        translate();
    }

    private void translate() {
        String ledgerEntry102 = this.pendingBundle;
        Map<String, String> channelTag103Attrs = new HashMap<String, String>();
        channelTag103Attrs.put("channel", "web");
        channelTag103Attrs.put("payload", ledgerEntry102);
        String channelTag103 = channelTag103Attrs.get("payload");
        AccountRegistry.forward(channelTag103);
    }
}
