package com.habench.paymentmerge.dao;

import com.habench.paymentmerge.dao.ContractBroker;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private static String cachedSession;

    public static void expand(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        cachedSession = quoteRef302;
        refine();
    }

    private static void refine() {
        String tariffRef303 = cachedSession;
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        cachedSession = ledgerEntry304;
        resolve();
    }

    private static void resolve() {
        String channelTag305 = cachedSession;
        Map<String, String> catalogKey306Attrs = new HashMap<String, String>();
        catalogKey306Attrs.put("channel", "web");
        catalogKey306Attrs.put("payload", channelTag305);
        String catalogKey306 = catalogKey306Attrs.get("payload");
        String receiptKey307 = catalogKey306;
        ContractBroker.register(receiptKey307);
    }
}
