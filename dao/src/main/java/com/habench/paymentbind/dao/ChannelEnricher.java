package com.habench.paymentbind.dao;

import com.habench.paymentbind.dao.SessionLoader;
import java.util.HashMap;
import java.util.Map;

public final class ChannelEnricher {
    private String pendingSession;

    public static void compose(String value) {
        ChannelEnricher self = new ChannelEnricher();
        self.expand(value);
    }

    private void expand(String value) {
        String shipmentCode601 = value;
        Map<String, String> manifestKey602Attrs = new HashMap<String, String>();
        manifestKey602Attrs.put("channel", "web");
        manifestKey602Attrs.put("payload", shipmentCode601);
        String manifestKey602 = manifestKey602Attrs.get("payload");
        this.pendingSession = manifestKey602;
        submit();
    }

    private void submit() {
        String invoiceKey603 = this.pendingSession;
        String batchTag604 = "ref:" + invoiceKey603 + ";";
        SessionLoader.resolve(batchTag604);
    }
}
