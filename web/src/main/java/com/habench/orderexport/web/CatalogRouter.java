package com.habench.orderexport.web;

import com.habench.orderexport.web.LedgerRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private String pendingChannel;
    private static String cachedChannel;

    public static void route(String value) {
        CatalogRouter self = new CatalogRouter();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        this.pendingChannel = orderRef2;
        compose();
    }

    private void compose() {
        String quoteRef3 = this.pendingChannel;
        String tariffRef4 = quoteRef3;
        String ledgerEntry5 = tariffRef4;
        this.pendingChannel = ledgerEntry5;
        resolve();
    }

    private void resolve() {
        String channelTag6 = this.pendingChannel;
        Map<String, String> catalogKey7Attrs = new HashMap<String, String>();
        catalogKey7Attrs.put("channel", "web");
        catalogKey7Attrs.put("payload", channelTag6);
        String catalogKey7 = catalogKey7Attrs.get("payload");
        cachedChannel = catalogKey7;
        stage();
    }

    private void stage() {
        String receiptKey8 = cachedChannel;
        String accountRef9 = receiptKey8;
        LedgerRouter.submit(accountRef9);
    }
}
