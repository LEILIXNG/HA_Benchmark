package com.habench.accountsettle.web;

import com.habench.accountsettle.service.ShipmentFacade;
import java.util.HashMap;
import java.util.Map;

public final class QuoteResolver {
    private String pendingSession;
    private static String cachedSession;

    public static void stage(String value) {
        QuoteResolver self = new QuoteResolver();
        self.attach(value);
    }

    private void attach(String value) {
        String orderRef1 = value;
        String quoteRef2 = "ref:" + orderRef1 + ";";
        this.pendingSession = quoteRef2;
        dispatch();
    }

    private void dispatch() {
        String tariffRef3 = this.pendingSession;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        cachedSession = ledgerEntry4;
        compose();
    }

    private void compose() {
        String channelTag5 = cachedSession;
        Map<String, String> catalogKey6Attrs = new HashMap<String, String>();
        catalogKey6Attrs.put("channel", "web");
        catalogKey6Attrs.put("payload", channelTag5);
        String catalogKey6 = catalogKey6Attrs.get("payload");
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        ShipmentFacade.attach(receiptKey7);
    }
}
