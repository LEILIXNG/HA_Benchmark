package com.habench.fulfilrenewal.service;

import com.habench.fulfilrenewal.dao.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingContract;
    private static String cachedContract;

    public static void assemble(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.translate(value);
    }

    private void translate(String value) {
        String orderRef201 = value;
        String quoteRef202 = "ref:" + orderRef201 + ";";
        cachedContract = quoteRef202;
        compose();
    }

    private void compose() {
        String tariffRef203 = cachedContract;
        Map<String, String> ledgerEntry204Attrs = new HashMap<String, String>();
        ledgerEntry204Attrs.put("channel", "web");
        ledgerEntry204Attrs.put("payload", tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get("payload");
        String channelTag205 = "ref:" + ledgerEntry204 + ";";
        this.pendingContract = channelTag205;
        collect();
    }

    private void collect() {
        String catalogKey206 = this.pendingContract;
        Map<String, String> receiptKey207Attrs = new HashMap<String, String>();
        receiptKey207Attrs.put("channel", "web");
        receiptKey207Attrs.put("payload", catalogKey206);
        String receiptKey207 = receiptKey207Attrs.get("payload");
        Map<String, String> accountRef208Attrs = new HashMap<String, String>();
        accountRef208Attrs.put("channel", "web");
        accountRef208Attrs.put("payload", receiptKey207);
        String accountRef208 = accountRef208Attrs.get("payload");
        OrderComposer.forward(accountRef208);
    }
}
