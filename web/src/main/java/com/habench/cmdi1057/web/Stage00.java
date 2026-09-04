package com.habench.cmdi1057.web;

import com.habench.cmdi1057.web.Handler01Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {

    public static void handle(String value) {
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        Handler01Dispatcher.apply(v1);
    }
}
