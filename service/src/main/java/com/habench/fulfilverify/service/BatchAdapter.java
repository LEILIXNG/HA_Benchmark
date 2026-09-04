package com.habench.fulfilverify.service;

import com.habench.fulfilverify.dao.AccountAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BatchAdapter {
    private static String cachedInvoice;

    public static void dispatch(String value) {
        String tariffRef301 = value;
        cachedInvoice = tariffRef301;
        merge();
    }

    private static void merge() {
        String ledgerEntry302 = cachedInvoice;
        Map<String, String> channelTag303Attrs = new HashMap<String, String>();
        channelTag303Attrs.put("channel", "web");
        channelTag303Attrs.put("payload", ledgerEntry302);
        String channelTag303 = channelTag303Attrs.get("payload");
        AccountAdapter.normalize(channelTag303);
    }
}
