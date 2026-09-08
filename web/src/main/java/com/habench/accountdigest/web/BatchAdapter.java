package com.habench.accountdigest.web;

import com.habench.accountdigest.web.RefundScreen;
import java.util.HashMap;
import java.util.Map;

public final class BatchAdapter {
    private static String cachedTariff;

    public static void merge(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        cachedTariff = tariffRef1;
        submit();
    }

    private static void submit() {
        String ledgerEntry2 = cachedTariff;
        Map<String, String> channelTag3Attrs = new HashMap<String, String>();
        channelTag3Attrs.put("channel", "web");
        channelTag3Attrs.put("payload", ledgerEntry2);
        String channelTag3 = channelTag3Attrs.get("payload");
        RefundScreen.assemble(channelTag3);
    }
}
