package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.service.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {
    private String pendingCatalog;

    public static void submit(String value) {
        SessionService self = new SessionService();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        this.pendingCatalog = quoteRef102;
        compose();
    }

    private void compose() {
        String tariffRef103 = this.pendingCatalog;
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("payload", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("payload");
        String channelTag105 = "ref:" + ledgerEntry104 + ";";
        CatalogRegistry.stage(channelTag105);
    }
}
