package com.habench.accountdraft.service;

import com.habench.accountdraft.service.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {
    private String pendingSession;

    public static void reconcile(String value) {
        OrderBuilder self = new OrderBuilder();
        self.resolve(value);
    }

    private void resolve(String value) {
        String quoteRef301 = value;
        Map<String, String> tariffRef302Attrs = new HashMap<String, String>();
        tariffRef302Attrs.put("channel", "web");
        tariffRef302Attrs.put("payload", quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get("payload");
        this.pendingSession = tariffRef302;
        assemble();
    }

    private void assemble() {
        String ledgerEntry303 = this.pendingSession;
        String channelTag304 = ledgerEntry303;
        SessionEvaluator.refine(channelTag304);
    }
}
