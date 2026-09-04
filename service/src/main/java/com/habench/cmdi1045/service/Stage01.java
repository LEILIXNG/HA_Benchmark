package com.habench.cmdi1045.service;

import com.habench.cmdi1045.service.Handler02Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = "order:" + v103 + ";";
        Handler02Dispatcher.apply(v104);
    }
}
