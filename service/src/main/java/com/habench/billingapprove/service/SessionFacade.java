package com.habench.billingapprove.service;

import com.habench.billingapprove.dao.VoucherRegistry;
import java.util.HashMap;
import java.util.Map;

public final class SessionFacade {

    public static void expand(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        VoucherRegistry.translate(channelTag102);
    }
}
