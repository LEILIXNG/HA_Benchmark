package com.habench.fulfilbind.dao;

import com.habench.fulfilbind.dao.BatchPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {
    private String pendingLedger;
    private static String cachedLedger;

    public static void forward(String value) {
        BundleBroker self = new BundleBroker();
        self.translate(value);
    }

    private void translate(String value) {
        String tariffRef401 = value;
        Map<String, String> ledgerEntry402Attrs = new HashMap<String, String>();
        ledgerEntry402Attrs.put("channel", "web");
        ledgerEntry402Attrs.put("payload", tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get("payload");
        cachedLedger = ledgerEntry402;
        attach();
    }

    private void attach() {
        String channelTag403 = cachedLedger;
        Map<String, String> catalogKey404Attrs = new HashMap<String, String>();
        catalogKey404Attrs.put("channel", "web");
        catalogKey404Attrs.put("payload", channelTag403);
        String catalogKey404 = catalogKey404Attrs.get("payload");
        this.pendingLedger = catalogKey404;
        merge();
    }

    private void merge() {
        String receiptKey405 = this.pendingLedger;
        String accountRef406 = receiptKey405;
        BatchPlanSelector.reconcile(accountRef406);
    }
}
