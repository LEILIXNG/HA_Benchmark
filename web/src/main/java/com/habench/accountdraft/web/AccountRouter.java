package com.habench.accountdraft.web;

import com.habench.accountdraft.service.InvoiceFacade;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {
    private String pendingSession;
    private static String cachedSession;

    public static void normalize(String value) {
        AccountRouter self = new AccountRouter();
        self.merge(value);
    }

    private void merge(String value) {
        String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        this.pendingSession = tariffRef2;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry3 = this.pendingSession;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        cachedSession = channelTag4;
        forward();
    }

    private void forward() {
        String catalogKey5 = cachedSession;
        String receiptKey6 = "ref:" + catalogKey5 + ";";
        Map<String, String> accountRef7Attrs = new HashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("payload", receiptKey6);
        String accountRef7 = accountRef7Attrs.get("payload");
        InvoiceFacade.forward(accountRef7);
    }
}
