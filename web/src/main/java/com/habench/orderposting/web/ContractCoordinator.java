package com.habench.orderposting.web;

import com.habench.orderposting.web.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractCoordinator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void translate(String value) {
        ContractCoordinator self = new ContractCoordinator();
        self.expand(value);
    }

    private void expand(String value) {
        String paymentTag1 = "ref:" + value + ";";
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        this.pendingOrder = refundCode2;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode3 = this.pendingOrder;
        String manifestKey4 = shipmentCode3;
        cachedOrder = manifestKey4;
        forward();
    }

    private void forward() {
        String invoiceKey5 = cachedOrder;
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("payload", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("payload");
        String orderRef7 = batchTag6;
        AccountPolicySelector.publish(orderRef7);
    }
}
