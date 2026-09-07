package com.habench.reportclose.web;

import com.habench.reportclose.web.BatchFacade;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {

    public static void enrich(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        BatchFacade.dispatch(refundCode1);
    }
}
