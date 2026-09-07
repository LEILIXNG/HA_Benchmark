package com.habench.customerverify.web;

import com.habench.customerverify.service.PaymentComposer;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {
    private String pendingTariff;

    public static void resolve(String value) {
        SessionResolver self = new SessionResolver();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = invoiceKey101;
        this.pendingTariff = batchTag102;
        normalize();
    }

    private void normalize() {
        String orderRef103 = this.pendingTariff;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        String tariffRef105 = "ref:" + quoteRef104 + ";";
        PaymentComposer.refine(tariffRef105);
    }
}
