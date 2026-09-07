package com.habench.billingdraft.dao;

import com.habench.billingdraft.dao.BundleBroker;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {

    public static void submit(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        BundleBroker.dispatch(channelTag302);
    }
}
