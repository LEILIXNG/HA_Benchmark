package com.habench.reportarchive.service;

import com.habench.reportarchive.service.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {
    private String pendingSession;

    public static void submit(String value) {
        TariffCollector self = new TariffCollector();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        this.pendingSession = tariffRef101;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry102 = this.pendingSession;
        String channelTag103 = "ref:" + ledgerEntry102 + ";";
        SessionEvaluator.prepare(channelTag103);
    }
}
