package com.habench.inventorycapture.web;

import com.habench.inventorycapture.web.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private String pendingChannel;
    private static String cachedChannel;

    public static void forward(String value) {
        InvoiceResolver self = new InvoiceResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String manifestKey1 = "ref:" + value + ";";
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        cachedChannel = invoiceKey2;
        collect();
    }

    private void collect() {
        String batchTag3 = cachedChannel;
        String orderRef4 = batchTag3;
        String quoteRef5 = "ref:" + orderRef4 + ";";
        this.pendingChannel = quoteRef5;
        translate();
    }

    private void translate() {
        String tariffRef6 = this.pendingChannel;
        String ledgerEntry7 = "ref:" + tariffRef6 + ";";
        ChannelExecutor.resolve(ledgerEntry7);
    }
}
