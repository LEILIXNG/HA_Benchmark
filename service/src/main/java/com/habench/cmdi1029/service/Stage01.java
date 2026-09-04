package com.habench.cmdi1029.service;

import com.habench.cmdi1029.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        String v102 = v101;
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = "order:" + v103 + ";";
        SinkHandler.execute(v104);
    }
}
