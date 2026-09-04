package com.habench.cmdi1033n.service;

import com.habench.cmdi1033n.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        Handler02Dispatcher.apply(v102);
    }
}
