package com.habench.shippingsettlequeue.web;

import com.habench.shippingsettlequeue.service.ContractRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private String pendingPayment;

    public static void enrich(String value) {
        CatalogCollector self = new CatalogCollector();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = ledgerEntry1;
        this.pendingPayment = channelTag2;
        register();
    }

    private void register() {
        String catalogKey3 = this.pendingPayment;
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        ContractRouter.forward(receiptKey4);
    }
}
