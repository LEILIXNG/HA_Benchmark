package com.habench.cmdi1033n.service;

import com.habench.cmdi1033n.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Map<String, String> attrs202 = new HashMap<String, String>();
        attrs202.put("channel", "web");
        attrs202.put("payload", v201);
        String v202 = attrs202.get("payload");
        cached = v202;
        stage1();
    }

    private static void stage1() {
        String v203 = cached;
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        String v205 = "order:" + v204 + ";";
        SinkHandler.execute(v205);
    }
}
