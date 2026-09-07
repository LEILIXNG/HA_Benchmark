package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.BatchRouter;
import java.util.HashMap;
import java.util.Map;

public final class ContractBuilder {

    public static void expand(String value) {
        Map<String, String> quoteRef401Attrs = new HashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("payload", value);
        String quoteRef401 = quoteRef401Attrs.get("payload");
        BatchRouter.publish(quoteRef401);
    }
}
