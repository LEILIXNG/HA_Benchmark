package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.service.LedgerRouter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {

    public static void submit(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        LedgerRouter.normalize(refundCode101);
    }
}
