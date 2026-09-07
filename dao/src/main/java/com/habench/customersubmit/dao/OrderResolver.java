package com.habench.customersubmit.dao;

import com.habench.customersubmit.dao.VoucherEnricher;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void stage(String value) {
        OrderResolver self = new OrderResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String quoteRef201 = "ref:" + value + ";";
        String tariffRef202 = quoteRef201;
        this.pendingCatalog = tariffRef202;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry203 = this.pendingCatalog;
        Map<String, String> channelTag204Attrs = new HashMap<String, String>();
        channelTag204Attrs.put("channel", "web");
        channelTag204Attrs.put("payload", ledgerEntry203);
        String channelTag204 = channelTag204Attrs.get("payload");
        cachedCatalog = channelTag204;
        normalize();
    }

    private void normalize() {
        String catalogKey205 = cachedCatalog;
        Map<String, String> receiptKey206Attrs = new HashMap<String, String>();
        receiptKey206Attrs.put("channel", "web");
        receiptKey206Attrs.put("payload", catalogKey205);
        String receiptKey206 = receiptKey206Attrs.get("payload");
        VoucherEnricher.stage(receiptKey206);
    }
}
