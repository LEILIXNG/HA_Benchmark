package com.habench.accounthold.service;

import com.habench.accounthold.dao.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class SessionAssembler {
    private String pendingSession;

    public static void publish(String value) {
        SessionAssembler self = new SessionAssembler();
        self.normalize(value);
    }

    private void normalize(String value) {
        String refundCode101 = value;
        this.pendingSession = refundCode101;
        attach();
    }

    private void attach() {
        String shipmentCode102 = this.pendingSession;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        OrderComposer.prepare(invoiceKey104);
    }
}
