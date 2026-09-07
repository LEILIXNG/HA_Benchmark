package com.habench.billingquote.web;

import com.habench.billingquote.web.SessionExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {
    private String pendingSession;

    public static void refine(String value) {
        ContractNormalizer self = new ContractNormalizer();
        self.stage(value);
    }

    private void stage(String value) {
        String refundCode1 = "ref:" + value + ";";
        this.pendingSession = refundCode1;
        enrich();
    }

    private void enrich() {
        String shipmentCode2 = this.pendingSession;
        Map<String, String> manifestKey3Attrs = new HashMap<String, String>();
        manifestKey3Attrs.put("channel", "web");
        manifestKey3Attrs.put("payload", shipmentCode2);
        String manifestKey3 = manifestKey3Attrs.get("payload");
        SessionExecutor.route(manifestKey3);
    }
}
