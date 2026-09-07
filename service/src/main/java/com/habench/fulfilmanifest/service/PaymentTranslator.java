package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.dao.LedgerRouter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentTranslator {
    private String pendingChannel;

    public static void resolve(String value) {
        PaymentTranslator self = new PaymentTranslator();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> ledgerEntry401Attrs = new HashMap<String, String>();
        ledgerEntry401Attrs.put("channel", "web");
        ledgerEntry401Attrs.put("payload", value);
        String ledgerEntry401 = ledgerEntry401Attrs.get("payload");
        this.pendingChannel = ledgerEntry401;
        assemble();
    }

    private void assemble() {
        String channelTag402 = this.pendingChannel;
        String catalogKey403 = "ref:" + channelTag402 + ";";
        LedgerRouter.resolve(catalogKey403);
    }
}
