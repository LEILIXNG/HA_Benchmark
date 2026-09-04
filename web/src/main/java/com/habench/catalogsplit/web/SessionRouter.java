package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.AccountLoader;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {
    private String pendingAccount;

    public static void enrich(String value) {
        SessionRouter self = new SessionRouter();
        self.normalize(value);
    }

    private void normalize(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = "ref:" + channelTag1 + ";";
        this.pendingAccount = catalogKey2;
        register();
    }

    private void register() {
        String receiptKey3 = this.pendingAccount;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        AccountLoader.publish(accountRef4);
    }
}
