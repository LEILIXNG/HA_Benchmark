package com.habench.fulfiladjust.service;

import com.habench.fulfiladjust.service.OrderLoader;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {
    private String pendingOrder;

    public static void dispatch(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String quoteRef201 = value;
        this.pendingOrder = quoteRef201;
        compose();
    }

    private void compose() {
        String tariffRef202 = this.pendingOrder;
        String ledgerEntry203 = tariffRef202;
        Map<String, String> channelTag204Attrs = new HashMap<String, String>();
        channelTag204Attrs.put("channel", "web");
        channelTag204Attrs.put("payload", ledgerEntry203);
        String channelTag204 = channelTag204Attrs.get("payload");
        OrderLoader.submit(channelTag204);
    }
}
