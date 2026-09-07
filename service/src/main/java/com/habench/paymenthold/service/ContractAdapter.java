package com.habench.paymenthold.service;

import com.habench.paymenthold.service.ManifestRouter;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {
    private String pendingPayment;

    public static void translate(String value) {
        ContractAdapter self = new ContractAdapter();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        String orderRef102 = batchTag101;
        this.pendingPayment = orderRef102;
        resolve();
    }

    private void resolve() {
        String quoteRef103 = this.pendingPayment;
        String tariffRef104 = quoteRef103;
        String ledgerEntry105 = "ref:" + tariffRef104 + ";";
        this.pendingPayment = ledgerEntry105;
        submit();
    }

    private void submit() {
        String channelTag106 = this.pendingPayment;
        String catalogKey107 = "ref:" + channelTag106 + ";";
        Map<String, String> receiptKey108Attrs = new HashMap<String, String>();
        receiptKey108Attrs.put("channel", "web");
        receiptKey108Attrs.put("payload", catalogKey107);
        String receiptKey108 = receiptKey108Attrs.get("payload");
        ManifestRouter.expand(receiptKey108);
    }
}
