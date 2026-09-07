package com.habench.inventorybind.web;

import com.habench.inventorybind.web.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {
    private String pendingSession;
    private static String cachedSession;

    public static void publish(String value) {
        BatchResolver self = new BatchResolver();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        this.pendingSession = invoiceKey2;
        refine();
    }

    private void refine() {
        String batchTag3 = this.pendingSession;
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        cachedSession = orderRef4;
        resolve();
    }

    private void resolve() {
        String quoteRef5 = cachedSession;
        String tariffRef6 = quoteRef5;
        cachedSession = tariffRef6;
        compose();
    }

    private void compose() {
        String ledgerEntry7 = cachedSession;
        String channelTag8 = "ref:" + ledgerEntry7 + ";";
        String catalogKey9 = "ref:" + channelTag8 + ";";
        QuoteTranslator.dispatch(catalogKey9);
    }
}
