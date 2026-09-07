package com.habench.pricingrefund.web;

import com.habench.pricingrefund.service.OrderFacade;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {
    private String pendingReceipt;

    public static void dispatch(String value) {
        BatchBroker self = new BatchBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        this.pendingReceipt = paymentTag102;
        stage();
    }

    private void stage() {
        String refundCode103 = this.pendingReceipt;
        String shipmentCode104 = "ref:" + refundCode103 + ";";
        this.pendingReceipt = shipmentCode104;
        expand();
    }

    private void expand() {
        String manifestKey105 = this.pendingReceipt;
        String invoiceKey106 = manifestKey105;
        OrderFacade.stage(invoiceKey106);
    }
}
