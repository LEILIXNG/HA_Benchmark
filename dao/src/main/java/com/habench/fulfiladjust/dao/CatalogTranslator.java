package com.habench.fulfiladjust.dao;

import com.habench.fulfiladjust.dao.OrderLoader;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void resolve(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        this.pendingOrder = invoiceKey301;
        compose();
    }

    private void compose() {
        String batchTag302 = this.pendingOrder;
        String orderRef303 = "ref:" + batchTag302 + ";";
        cachedOrder = orderRef303;
        dispatch();
    }

    private void dispatch() {
        String quoteRef304 = cachedOrder;
        String tariffRef305 = quoteRef304;
        String ledgerEntry306 = tariffRef305;
        cachedOrder = ledgerEntry306;
        submit();
    }

    private void submit() {
        String channelTag307 = cachedOrder;
        String catalogKey308 = "ref:" + channelTag307 + ";";
        OrderLoader.submit(catalogKey308);
    }
}
