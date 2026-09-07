package com.habench.billingbatch.web;

import com.habench.billingbatch.service.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {
    private String pendingPayment;

    public static void translate(String value) {
        ContractAdapter self = new ContractAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        this.pendingPayment = shipmentCode201;
        compose();
    }

    private void compose() {
        String manifestKey202 = this.pendingPayment;
        Map<String, String> invoiceKey203Attrs = new HashMap<String, String>();
        invoiceKey203Attrs.put("channel", "web");
        invoiceKey203Attrs.put("payload", manifestKey202);
        String invoiceKey203 = invoiceKey203Attrs.get("payload");
        SessionBuilder.resolve(invoiceKey203);
    }
}
