package com.habench.accountreconcile.dao;

import com.habench.accountreconcile.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ChannelFacade {

    public static void translate(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        BatchExecutor.merge(ledgerEntry201);
    }
}
