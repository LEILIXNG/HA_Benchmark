package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.service.ManifestResolver;
import java.util.HashMap;
import java.util.Map;

public final class SessionTranslator {
    private String pendingInvoice;

    public static void publish(String value) {
        SessionTranslator self = new SessionTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        String batchTag101 = "ref:" + value + ";";
        this.pendingInvoice = batchTag101;
        refine();
    }

    private void refine() {
        String orderRef102 = this.pendingInvoice;
        Map<String, String> quoteRef103Attrs = new HashMap<String, String>();
        quoteRef103Attrs.put("channel", "web");
        quoteRef103Attrs.put("payload", orderRef102);
        String quoteRef103 = quoteRef103Attrs.get("payload");
        String tariffRef104 = "ref:" + quoteRef103 + ";";
        ManifestResolver.reconcile(tariffRef104);
    }
}
