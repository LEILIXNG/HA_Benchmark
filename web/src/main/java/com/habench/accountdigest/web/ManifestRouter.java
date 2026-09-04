package com.habench.accountdigest.web;

import com.habench.accountdigest.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingPayment;
    private static String cachedPayment;

    public static void dispatch(String value) {
        ManifestRouter self = new ManifestRouter();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        this.pendingPayment = manifestKey101;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey102 = this.pendingPayment;
        String batchTag103 = invoiceKey102;
        String orderRef104 = "ref:" + batchTag103 + ";";
        this.pendingPayment = orderRef104;
        translate();
    }

    private void translate() {
        String quoteRef105 = this.pendingPayment;
        String tariffRef106 = "ref:" + quoteRef105 + ";";
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("payload", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("payload");
        cachedPayment = ledgerEntry107;
        assemble();
    }

    private void assemble() {
        String channelTag108 = cachedPayment;
        String catalogKey109 = channelTag108;
        OrderComposer.forward(catalogKey109);
    }
}
