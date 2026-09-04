package com.habench.fulfiltransfer.dao;

import com.habench.fulfiltransfer.dao.QuoteStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private static String cachedTariff;

    public static void register(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = channelTag201;
        cachedTariff = catalogKey202;
        reconcile();
    }

    private static void reconcile() {
        String receiptKey203 = cachedTariff;
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("payload", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("payload");
        QuoteStrategySelector.attach(accountRef204);
    }
}
