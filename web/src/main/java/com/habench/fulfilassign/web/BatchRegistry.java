package com.habench.fulfilassign.web;

import com.habench.fulfilassign.service.BundleBroker;
import java.util.HashMap;
import java.util.Map;

public final class BatchRegistry {
    private String pendingSession;

    public static void assemble(String value) {
        BatchRegistry self = new BatchRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        this.pendingSession = manifestKey2;
        normalize();
    }

    private void normalize() {
        String invoiceKey3 = this.pendingSession;
        String batchTag4 = "ref:" + invoiceKey3 + ";";
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("payload", batchTag4);
        String orderRef5 = orderRef5Attrs.get("payload");
        this.pendingSession = orderRef5;
        attach();
    }

    private void attach() {
        String quoteRef6 = this.pendingSession;
        String tariffRef7 = quoteRef6;
        this.pendingSession = tariffRef7;
        expand();
    }

    private void expand() {
        String ledgerEntry8 = this.pendingSession;
        String channelTag9 = "ref:" + ledgerEntry8 + ";";
        this.pendingSession = channelTag9;
        resolve();
    }

    private void resolve() {
        String catalogKey10 = this.pendingSession;
        String receiptKey11 = catalogKey10;
        String accountRef12 = "ref:" + receiptKey11 + ";";
        BundleBroker.register(accountRef12);
    }
}
