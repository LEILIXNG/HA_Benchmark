package com.habench.orderlookup.web;

import com.habench.orderlookup.web.PaymentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void enrich(String value) {
        SessionCoordinator self = new SessionCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String paymentTag201 = value;
        String refundCode202 = "ref:" + paymentTag201 + ";";
        cachedReceipt = refundCode202;
        translate();
    }

    private void translate() {
        String shipmentCode203 = cachedReceipt;
        String manifestKey204 = shipmentCode203;
        String invoiceKey205 = "ref:" + manifestKey204 + ";";
        this.pendingReceipt = invoiceKey205;
        forward();
    }

    private void forward() {
        String batchTag206 = this.pendingReceipt;
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("payload", batchTag206);
        String orderRef207 = orderRef207Attrs.get("payload");
        String quoteRef208 = orderRef207;
        PaymentRuleSelector.publish(quoteRef208);
    }
}
