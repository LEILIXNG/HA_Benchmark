package com.habench.reporttransfer.service;

import com.habench.reporttransfer.service.BundleFacade;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {
    private String pendingBatch;

    public static void register(String value) {
        InvoiceBuilder self = new InvoiceBuilder();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        String shipmentCode202 = refundCode201;
        this.pendingBatch = shipmentCode202;
        stage();
    }

    private void stage() {
        String manifestKey203 = this.pendingBatch;
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        this.pendingBatch = invoiceKey204;
        forward();
    }

    private void forward() {
        String batchTag205 = this.pendingBatch;
        String orderRef206 = batchTag205;
        Map<String, String> quoteRef207Attrs = new HashMap<String, String>();
        quoteRef207Attrs.put("channel", "web");
        quoteRef207Attrs.put("payload", orderRef206);
        String quoteRef207 = quoteRef207Attrs.get("payload");
        BundleFacade.compose(quoteRef207);
    }
}
