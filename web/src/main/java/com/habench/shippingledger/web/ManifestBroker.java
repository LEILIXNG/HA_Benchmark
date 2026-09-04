package com.habench.shippingledger.web;

import com.habench.shippingledger.web.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBroker {
    private String pendingBatch;

    public static void publish(String value) {
        ManifestBroker self = new ManifestBroker();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef1 = "ref:" + value + ";";
        this.pendingBatch = orderRef1;
        merge();
    }

    private void merge() {
        String quoteRef2 = this.pendingBatch;
        Map<String, String> tariffRef3Attrs = new HashMap<String, String>();
        tariffRef3Attrs.put("channel", "web");
        tariffRef3Attrs.put("payload", quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get("payload");
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        this.pendingBatch = ledgerEntry4;
        resolve();
    }

    private void resolve() {
        String channelTag5 = this.pendingBatch;
        String catalogKey6 = "ref:" + channelTag5 + ";";
        String receiptKey7 = catalogKey6;
        ShipmentRouter.merge(receiptKey7);
    }
}
