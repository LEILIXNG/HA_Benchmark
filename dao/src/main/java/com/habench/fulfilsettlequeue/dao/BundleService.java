package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.SessionScreen;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {
    private String pendingLedger;

    public static void collect(String value) {
        BundleService self = new BundleService();
        self.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry401 = value;
        String channelTag402 = ledgerEntry401;
        this.pendingLedger = channelTag402;
        dispatch();
    }

    private void dispatch() {
        String catalogKey403 = this.pendingLedger;
        String receiptKey404 = catalogKey403;
        Map<String, String> accountRef405Attrs = new HashMap<String, String>();
        accountRef405Attrs.put("channel", "web");
        accountRef405Attrs.put("payload", receiptKey404);
        String accountRef405 = accountRef405Attrs.get("payload");
        SessionScreen.register(accountRef405);
    }
}
