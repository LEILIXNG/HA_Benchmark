package com.habench.path1002.web;

import com.habench.path1002.web.Handler04Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {

    public static void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        String v302 = "order:" + v301 + ";";
        Handler04Dispatcher.apply(v302);
    }
}
