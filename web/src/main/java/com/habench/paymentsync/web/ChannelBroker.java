package com.habench.paymentsync.web;

import com.habench.paymentsync.service.LedgerAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBroker {

    public static void prepare(String value) {
        String quoteRef1 = "ref:" + value + ";";
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        LedgerAdapter.stage(tariffRef2);
    }
}
