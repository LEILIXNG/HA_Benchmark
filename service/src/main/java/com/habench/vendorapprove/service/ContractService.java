package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.RefundGuard;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {
    private String pendingReceipt;

    public static void submit(String value) {
        ContractService self = new ContractService();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        this.pendingReceipt = invoiceKey201;
        translate();
    }

    private void translate() {
        String batchTag202 = this.pendingReceipt;
        String orderRef203 = "ref:" + batchTag202 + ";";
        RefundGuard.compose(orderRef203);
    }
}
