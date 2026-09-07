package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.ContractBroker;
import java.util.HashMap;
import java.util.Map;

public final class SessionAssembler {
    private static String cachedVoucher;

    public static void submit(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedVoucher = quoteRef2;
        compose();
    }

    private static void compose() {
        String tariffRef3 = cachedVoucher;
        String ledgerEntry4 = tariffRef3;
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        ContractBroker.stage(channelTag5);
    }
}
