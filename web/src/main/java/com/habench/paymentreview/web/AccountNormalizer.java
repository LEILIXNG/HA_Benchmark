package com.habench.paymentreview.web;

import com.habench.paymentreview.web.SessionRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountNormalizer {

    public static void route(String value) {
        String quoteRef201 = "ref:" + value + ";";
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("payload", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("payload");
        SessionRouter.stage(tariffRef202);
    }
}
