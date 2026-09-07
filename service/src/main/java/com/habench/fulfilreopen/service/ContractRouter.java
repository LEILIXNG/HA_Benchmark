package com.habench.fulfilreopen.service;

import com.habench.fulfilreopen.dao.InvoiceComposer;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {
    private String pendingRefund;

    public static void publish(String value) {
        ContractRouter self = new ContractRouter();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        this.pendingRefund = paymentTag101;
        enrich();
    }

    private void enrich() {
        String refundCode102 = this.pendingRefund;
        String shipmentCode103 = "ref:" + refundCode102 + ";";
        InvoiceComposer.enrich(shipmentCode103);
    }
}
