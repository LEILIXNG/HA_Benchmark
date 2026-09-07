package com.habench.orderrevise.service;

import com.habench.orderrevise.service.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void compose(String value) {
        SessionRegistry self = new SessionRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        String refundCode201 = value;
        String shipmentCode202 = refundCode201;
        this.pendingBundle = shipmentCode202;
        refine();
    }

    private void refine() {
        String manifestKey203 = this.pendingBundle;
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("payload", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("payload");
        cachedBundle = invoiceKey204;
        register();
    }

    private void register() {
        String batchTag205 = cachedBundle;
        String orderRef206 = "ref:" + batchTag205 + ";";
        Map<String, String> quoteRef207Attrs = new HashMap<String, String>();
        quoteRef207Attrs.put("channel", "web");
        quoteRef207Attrs.put("payload", orderRef206);
        String quoteRef207 = quoteRef207Attrs.get("payload");
        RefundPolicySelector.resolve(quoteRef207);
    }
}
