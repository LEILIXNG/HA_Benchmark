package com.habench.path1018.service;

import com.habench.path1018.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        cached = v101;
        stage1();
    }

    private static void stage1() {
        String v102 = cached;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        String v104 = "order:" + v103 + ";";
        Handler02Dispatcher.apply(v104);
    }
}
