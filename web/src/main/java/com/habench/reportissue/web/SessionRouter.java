package com.habench.reportissue.web;

import com.habench.reportissue.web.VoucherResolver;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {
    private String pendingContract;
    private static String cachedContract;

    public static void prepare(String value) {
        SessionRouter self = new SessionRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String manifestKey101 = value;
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        this.pendingContract = invoiceKey102;
        reconcile();
    }

    private void reconcile() {
        String batchTag103 = this.pendingContract;
        String orderRef104 = batchTag103;
        cachedContract = orderRef104;
        register();
    }

    private void register() {
        String quoteRef105 = cachedContract;
        String tariffRef106 = "ref:" + quoteRef105 + ";";
        String ledgerEntry107 = "ref:" + tariffRef106 + ";";
        cachedContract = ledgerEntry107;
        enrich();
    }

    private void enrich() {
        String channelTag108 = cachedContract;
        String catalogKey109 = channelTag108;
        Map<String, String> receiptKey110Attrs = new HashMap<String, String>();
        receiptKey110Attrs.put("channel", "web");
        receiptKey110Attrs.put("payload", catalogKey109);
        String receiptKey110 = receiptKey110Attrs.get("payload");
        VoucherResolver.stage(receiptKey110);
    }
}
