package com.habench.catalogrefund.web;

import com.habench.catalogrefund.service.PaymentComposer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void route(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        PaymentComposer.refine(channelTag102);
    }
}
