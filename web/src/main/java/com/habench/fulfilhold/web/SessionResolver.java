package com.habench.fulfilhold.web;

import com.habench.fulfilhold.web.PaymentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {

    public static void translate(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        PaymentCoordinator.compose(tariffRef2);
    }
}
