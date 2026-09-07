package com.habench.billingquote.dao;

import com.habench.billingquote.dao.SessionExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {
    private String pendingSession;

    public static void refine(String value) {
        ContractNormalizer self = new ContractNormalizer();
        self.stage(value);
    }

    private void stage(String value) {
        String refundCode301 = value;
        Map<String, String> shipmentCode302Attrs = new HashMap<String, String>();
        shipmentCode302Attrs.put("channel", "web");
        shipmentCode302Attrs.put("payload", refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get("payload");
        this.pendingSession = shipmentCode302;
        enrich();
    }

    private void enrich() {
        String manifestKey303 = this.pendingSession;
        String invoiceKey304 = manifestKey303;
        SessionExecutor.route(invoiceKey304);
    }
}
