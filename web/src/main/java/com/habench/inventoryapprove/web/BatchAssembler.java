package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.BundleRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchAssembler {
    private String pendingReceipt;

    public static void collect(String value) {
        BatchAssembler self = new BatchAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        this.pendingReceipt = shipmentCode1;
        merge();
    }

    private void merge() {
        String manifestKey2 = this.pendingReceipt;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        BundleRuleSelector.register(invoiceKey3);
    }
}
