package com.habench.orderreview.web;

import com.habench.orderreview.service.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {
    private String pendingSession;

    public static void dispatch(String value) {
        ReceiptEnricher self = new ReceiptEnricher();
        self.prepare(value);
    }

    private void prepare(String value) {
        String quoteRef101 = value;
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        this.pendingSession = tariffRef102;
        stage();
    }

    private void stage() {
        String ledgerEntry103 = this.pendingSession;
        String channelTag104 = ledgerEntry103;
        ManifestService.reconcile(channelTag104);
    }
}
