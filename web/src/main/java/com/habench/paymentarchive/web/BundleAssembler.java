package com.habench.paymentarchive.web;

import com.habench.paymentarchive.service.BundleResolver;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {
    private String pendingSession;
    private static String cachedSession;

    public static void translate(String value) {
        BundleAssembler self = new BundleAssembler();
        self.route(value);
    }

    private void route(String value) {
        String invoiceKey1 = value;
        cachedSession = invoiceKey1;
        submit();
    }

    private void submit() {
        String batchTag2 = cachedSession;
        Map<String, String> orderRef3Attrs = new HashMap<String, String>();
        orderRef3Attrs.put("channel", "web");
        orderRef3Attrs.put("payload", batchTag2);
        String orderRef3 = orderRef3Attrs.get("payload");
        this.pendingSession = orderRef3;
        register();
    }

    private void register() {
        String quoteRef4 = this.pendingSession;
        Map<String, String> tariffRef5Attrs = new HashMap<String, String>();
        tariffRef5Attrs.put("channel", "web");
        tariffRef5Attrs.put("payload", quoteRef4);
        String tariffRef5 = tariffRef5Attrs.get("payload");
        String ledgerEntry6 = "ref:" + tariffRef5 + ";";
        this.pendingSession = ledgerEntry6;
        refine();
    }

    private void refine() {
        String channelTag7 = this.pendingSession;
        String catalogKey8 = "ref:" + channelTag7 + ";";
        String receiptKey9 = catalogKey8;
        BundleResolver.normalize(receiptKey9);
    }
}
