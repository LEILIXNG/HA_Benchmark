package com.habench.fulfilsubmit.web;

import com.habench.fulfilsubmit.service.ShipmentFacade;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRegistry {
    private String pendingReceipt;

    public static void publish(String value) {
        VoucherRegistry self = new VoucherRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        this.pendingReceipt = batchTag2;
        prepare();
    }

    private void prepare() {
        String orderRef3 = this.pendingReceipt;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        ShipmentFacade.prepare(quoteRef4);
    }
}
