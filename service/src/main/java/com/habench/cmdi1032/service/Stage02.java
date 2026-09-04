package com.habench.cmdi1032.service;

import com.habench.cmdi1032.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = value;
        cached = v201;
        stage1();
    }

    private static void stage1() {
        String v202 = cached;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        String v204 = "order:" + v203 + ";";
        cached = v204;
        stage2();
    }

    private static void stage2() {
        String v205 = cached;
        String v206 = v205;
        SinkHandler.execute(v206);
    }
}
