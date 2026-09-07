package com.habench.paymentmerge.service;

import com.habench.paymentmerge.dao.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCollector {
    private String pendingSession;
    private static String cachedSession;

    public static void route(String value) {
        QuoteCollector self = new QuoteCollector();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        cachedSession = shipmentCode102;
        collect();
    }

    private void collect() {
        String manifestKey103 = cachedSession;
        String invoiceKey104 = manifestKey103;
        this.pendingSession = invoiceKey104;
        publish();
    }

    private void publish() {
        String batchTag105 = this.pendingSession;
        Map<String, String> orderRef106Attrs = new HashMap<String, String>();
        orderRef106Attrs.put("channel", "web");
        orderRef106Attrs.put("payload", batchTag105);
        String orderRef106 = orderRef106Attrs.get("payload");
        this.pendingSession = orderRef106;
        attach();
    }

    private void attach() {
        String quoteRef107 = this.pendingSession;
        String tariffRef108 = quoteRef107;
        ChannelRouter.register(tariffRef108);
    }
}
