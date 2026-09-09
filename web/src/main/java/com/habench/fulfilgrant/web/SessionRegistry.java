package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.service.SessionRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        SessionRegistry self = new SessionRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        cachedReceipt = manifestKey1;
        collect();
    }

    private void collect() {
        String invoiceKey2 = cachedReceipt;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("payload", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("payload");
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        this.pendingReceipt = orderRef4;
        register();
    }

    private void register() {
        String quoteRef5 = this.pendingReceipt;
        String tariffRef6 = "ref:" + quoteRef5 + ";";
        this.pendingReceipt = tariffRef6;
        prepare();
    }

    private void prepare() {
        String ledgerEntry7 = this.pendingReceipt;
        String channelTag8 = "ref:" + ledgerEntry7 + ";";
        String catalogKey9 = "ref:" + channelTag8 + ";";
        cachedReceipt = catalogKey9;
        merge();
    }

    private void merge() {
        String receiptKey10 = cachedReceipt;
        String accountRef11 = "ref:" + receiptKey10 + ";";
        SessionRouter.expand(accountRef11);
    }
}
