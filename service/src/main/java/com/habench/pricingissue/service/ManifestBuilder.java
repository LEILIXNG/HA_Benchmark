package com.habench.pricingissue.service;

import com.habench.pricingissue.service.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBuilder {
    private String pendingBundle;
    private static String cachedBundle;

    public static void expand(String value) {
        ManifestBuilder self = new ManifestBuilder();
        self.merge(value);
    }

    private void merge(String value) {
        String manifestKey101 = "ref:" + value + ";";
        String invoiceKey102 = manifestKey101;
        this.pendingBundle = invoiceKey102;
        submit();
    }

    private void submit() {
        String batchTag103 = this.pendingBundle;
        String orderRef104 = "ref:" + batchTag103 + ";";
        String quoteRef105 = orderRef104;
        this.pendingBundle = quoteRef105;
        compose();
    }

    private void compose() {
        String tariffRef106 = this.pendingBundle;
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("payload", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("payload");
        this.pendingBundle = ledgerEntry107;
        enrich();
    }

    private void enrich() {
        String channelTag108 = this.pendingBundle;
        String catalogKey109 = channelTag108;
        String receiptKey110 = catalogKey109;
        this.pendingBundle = receiptKey110;
        reconcile();
    }

    private void reconcile() {
        String accountRef111 = this.pendingBundle;
        String voucherRef112 = accountRef111;
        cachedBundle = voucherRef112;
        dispatch();
    }

    private void dispatch() {
        String paymentTag113 = cachedBundle;
        String refundCode114 = "ref:" + paymentTag113 + ";";
        QuotePolicySelector.refine(refundCode114);
    }
}
