package com.habench.catalogmerge.service;

import com.habench.catalogmerge.service.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private String pendingChannel;

    public static void collect(String value) {
        RefundFacade self = new RefundFacade();
        self.translate(value);
    }

    private void translate(String value) {
        String refundCode201 = value;
        this.pendingChannel = refundCode201;
        attach();
    }

    private void attach() {
        String shipmentCode202 = this.pendingChannel;
        String manifestKey203 = shipmentCode202;
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        this.pendingChannel = invoiceKey204;
        register();
    }

    private void register() {
        String batchTag205 = this.pendingChannel;
        String orderRef206 = "ref:" + batchTag205 + ";";
        Map<String, String> quoteRef207Attrs = new HashMap<String, String>();
        quoteRef207Attrs.put("channel", "web");
        quoteRef207Attrs.put("payload", orderRef206);
        String quoteRef207 = quoteRef207Attrs.get("payload");
        ChannelExecutor.collect(quoteRef207);
    }
}
