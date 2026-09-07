package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.web.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {
    private String pendingSession;

    public static void assemble(String value) {
        AccountRouter self = new AccountRouter();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        this.pendingSession = invoiceKey2;
        attach();
    }

    private void attach() {
        String batchTag3 = this.pendingSession;
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        ChannelRouter.attach(quoteRef5);
    }
}
