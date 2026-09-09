package com.habench.pricingposting.service;

import com.habench.pricingposting.service.BatchFetcher;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {
    private String pendingBatch;

    public static void dispatch(String value) {
        BatchFacade self = new BatchFacade();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        this.pendingBatch = orderRef101;
        publish();
    }

    private void publish() {
        String quoteRef102 = this.pendingBatch;
        Map<String, String> tariffRef103Attrs = new HashMap<String, String>();
        tariffRef103Attrs.put("channel", "web");
        tariffRef103Attrs.put("payload", quoteRef102);
        String tariffRef103 = tariffRef103Attrs.get("payload");
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        this.pendingBatch = ledgerEntry104;
        normalize();
    }

    private void normalize() {
        String channelTag105 = this.pendingBatch;
        String catalogKey106 = channelTag105;
        String receiptKey107 = catalogKey106;
        BatchFetcher.merge(receiptKey107);
    }
}
