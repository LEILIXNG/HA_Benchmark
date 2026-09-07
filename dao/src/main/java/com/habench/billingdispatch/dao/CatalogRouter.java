package com.habench.billingdispatch.dao;

import com.habench.billingdispatch.dao.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private String pendingChannel;
    private static String cachedChannel;

    public static void refine(String value) {
        CatalogRouter self = new CatalogRouter();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        cachedChannel = channelTag301;
        dispatch();
    }

    private void dispatch() {
        String catalogKey302 = cachedChannel;
        String receiptKey303 = catalogKey302;
        this.pendingChannel = receiptKey303;
        translate();
    }

    private void translate() {
        String accountRef304 = this.pendingChannel;
        Map<String, String> voucherRef305Attrs = new HashMap<String, String>();
        voucherRef305Attrs.put("channel", "web");
        voucherRef305Attrs.put("payload", accountRef304);
        String voucherRef305 = voucherRef305Attrs.get("payload");
        LedgerPolicySelector.prepare(voucherRef305);
    }
}
