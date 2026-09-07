package com.habench.fulfilrenewal.service;

import com.habench.fulfilrenewal.dao.QuoteRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionComposer {
    private String pendingSession;

    public static void stage(String value) {
        SessionComposer self = new SessionComposer();
        self.translate(value);
    }

    private void translate(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        this.pendingSession = refundCode102;
        assemble();
    }

    private void assemble() {
        String shipmentCode103 = this.pendingSession;
        String manifestKey104 = shipmentCode103;
        QuoteRouter.normalize(manifestKey104);
    }
}
