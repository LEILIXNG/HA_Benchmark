package com.habench.shippingledger.web;

import com.habench.shippingledger.service.ChannelCollector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {
    private String pendingBatch;

    public static void stage(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.register(value);
    }

    private void register(String value) {
        String receiptKey201 = "ref:" + value + ";";
        this.pendingBatch = receiptKey201;
        refine();
    }

    private void refine() {
        String accountRef202 = this.pendingBatch;
        String voucherRef203 = "ref:" + accountRef202 + ";";
        String paymentTag204 = "ref:" + voucherRef203 + ";";
        this.pendingBatch = paymentTag204;
        merge();
    }

    private void merge() {
        String refundCode205 = this.pendingBatch;
        String shipmentCode206 = "ref:" + refundCode205 + ";";
        this.pendingBatch = shipmentCode206;
        dispatch();
    }

    private void dispatch() {
        String manifestKey207 = this.pendingBatch;
        Map<String, String> invoiceKey208Attrs = new HashMap<String, String>();
        invoiceKey208Attrs.put("channel", "web");
        invoiceKey208Attrs.put("payload", manifestKey207);
        String invoiceKey208 = invoiceKey208Attrs.get("payload");
        String batchTag209 = invoiceKey208;
        ChannelCollector.submit(batchTag209);
    }
}
