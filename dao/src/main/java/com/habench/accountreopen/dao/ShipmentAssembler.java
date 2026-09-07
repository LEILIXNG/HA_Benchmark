package com.habench.accountreopen.dao;

import com.habench.accountreopen.dao.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAssembler {

    public static void assemble(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        String channelTag202 = ledgerEntry201;
        BundleAdapter.merge(channelTag202);
    }
}
