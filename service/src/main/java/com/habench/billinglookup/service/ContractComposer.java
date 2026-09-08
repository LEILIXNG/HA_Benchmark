package com.habench.billinglookup.service;

import com.habench.billinglookup.service.OrderPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {
    private String pendingContract;
    private static String cachedContract;

    public static void submit(String value) {
        ContractComposer self = new ContractComposer();
        self.merge(value);
    }

    private void merge(String value) {
        String manifestKey101 = "ref:" + value + ";";
        this.pendingContract = manifestKey101;
        register();
    }

    private void register() {
        String invoiceKey102 = this.pendingContract;
        String batchTag103 = invoiceKey102;
        cachedContract = batchTag103;
        collect();
    }

    private void collect() {
        String orderRef104 = cachedContract;
        String quoteRef105 = "ref:" + orderRef104 + ";";
        this.pendingContract = quoteRef105;
        reconcile();
    }

    private void reconcile() {
        String tariffRef106 = this.pendingContract;
        String ledgerEntry107 = "ref:" + tariffRef106 + ";";
        cachedContract = ledgerEntry107;
        normalize();
    }

    private void normalize() {
        String channelTag108 = cachedContract;
        Map<String, String> catalogKey109Attrs = new HashMap<String, String>();
        catalogKey109Attrs.put("channel", "web");
        catalogKey109Attrs.put("payload", channelTag108);
        String catalogKey109 = catalogKey109Attrs.get("payload");
        String receiptKey110 = "ref:" + catalogKey109 + ";";
        this.pendingContract = receiptKey110;
        dispatch();
    }

    private void dispatch() {
        String accountRef111 = this.pendingContract;
        String voucherRef112 = accountRef111;
        String paymentTag113 = voucherRef112;
        OrderPolicy.publish(paymentTag113);
    }
}
