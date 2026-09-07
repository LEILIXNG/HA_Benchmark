package com.habench.fulfilquote.service;

import com.habench.fulfilquote.dao.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {
    private static String cachedTariff;

    public static void resolve(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = tariffRef201;
        cachedTariff = ledgerEntry202;
        translate();
    }

    private static void translate() {
        String channelTag203 = cachedTariff;
        String catalogKey204 = "ref:" + channelTag203 + ";";
        BundleAdapter.assemble(catalogKey204);
    }
}
