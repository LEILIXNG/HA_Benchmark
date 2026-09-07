package com.habench.catalognotice.web;

import com.habench.catalognotice.service.AccountAdapter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private String pendingOrder;

    public static void assemble(String value) {
        PaymentBuilder self = new PaymentBuilder();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String paymentTag1 = value;
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        this.pendingOrder = refundCode2;
        merge();
    }

    private void merge() {
        String shipmentCode3 = this.pendingOrder;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        AccountAdapter.normalize(invoiceKey5);
    }
}
