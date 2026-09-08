package com.habench.paymentlookup.dao;

import com.habench.paymentlookup.dao.BatchRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private static String cachedSession;

    public static void merge(String value) {
        String channelTag201 = value;
        String catalogKey202 = "ref:" + channelTag201 + ";";
        cachedSession = catalogKey202;
        reconcile();
    }

    private static void reconcile() {
        String receiptKey203 = cachedSession;
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("payload", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("payload");
        String voucherRef205 = "ref:" + accountRef204 + ";";
        BatchRuleSelector.attach(voucherRef205);
    }
}
