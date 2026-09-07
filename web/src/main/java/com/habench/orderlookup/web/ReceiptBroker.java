package com.habench.orderlookup.web;

import com.habench.orderlookup.web.InvoicePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {
    private String pendingContract;

    public static void refine(String value) {
        ReceiptBroker self = new ReceiptBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        this.pendingContract = refundCode1;
        translate();
    }

    private void translate() {
        String shipmentCode2 = this.pendingContract;
        String manifestKey3 = shipmentCode2;
        String invoiceKey4 = manifestKey3;
        InvoicePolicySelector.reconcile(invoiceKey4);
    }
}
