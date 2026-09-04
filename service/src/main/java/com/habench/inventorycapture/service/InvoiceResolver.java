package com.habench.inventorycapture.service;

import com.habench.inventorycapture.service.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private String pendingChannel;

    public static void translate(String value) {
        InvoiceResolver self = new InvoiceResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String invoiceKey101 = value;
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        this.pendingChannel = batchTag102;
        collect();
    }

    private void collect() {
        String orderRef103 = this.pendingChannel;
        String quoteRef104 = orderRef103;
        String tariffRef105 = quoteRef104;
        ChannelExecutor.resolve(tariffRef105);
    }
}
