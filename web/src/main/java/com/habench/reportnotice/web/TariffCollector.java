package com.habench.reportnotice.web;

import com.habench.reportnotice.web.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {
    private String pendingReceipt;

    public static void forward(String value) {
        TariffCollector self = new TariffCollector();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        this.pendingReceipt = batchTag1;
        reconcile();
    }

    private void reconcile() {
        String orderRef2 = this.pendingReceipt;
        String quoteRef3 = orderRef2;
        String tariffRef4 = quoteRef3;
        PaymentPolicySelector.dispatch(tariffRef4);
    }
}
