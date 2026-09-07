package com.habench.fulfillookup.web;

import com.habench.fulfillookup.service.ContractAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private String pendingPayment;

    public static void stage(String value) {
        BundleBuilder self = new BundleBuilder();
        self.forward(value);
    }

    private void forward(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = invoiceKey1;
        this.pendingPayment = batchTag2;
        enrich();
    }

    private void enrich() {
        String orderRef3 = this.pendingPayment;
        String quoteRef4 = orderRef3;
        this.pendingPayment = quoteRef4;
        refine();
    }

    private void refine() {
        String tariffRef5 = this.pendingPayment;
        String ledgerEntry6 = "ref:" + tariffRef5 + ";";
        Map<String, String> channelTag7Attrs = new HashMap<String, String>();
        channelTag7Attrs.put("channel", "web");
        channelTag7Attrs.put("payload", ledgerEntry6);
        String channelTag7 = channelTag7Attrs.get("payload");
        ContractAdapter.refine(channelTag7);
    }
}
