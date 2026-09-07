package com.habench.accountarchive.dao;

import com.habench.accountarchive.dao.SessionLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {
    private String pendingSession;

    public static void register(String value) {
        AccountBuilder self = new AccountBuilder();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        this.pendingSession = tariffRef401;
        stage();
    }

    private void stage() {
        String ledgerEntry402 = this.pendingSession;
        Map<String, String> channelTag403Attrs = new HashMap<String, String>();
        channelTag403Attrs.put("channel", "web");
        channelTag403Attrs.put("payload", ledgerEntry402);
        String channelTag403 = channelTag403Attrs.get("payload");
        SessionLoader.reconcile(channelTag403);
    }
}
