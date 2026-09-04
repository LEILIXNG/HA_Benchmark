package com.habench.path1009.service;

import com.habench.path1009.service.Handler04Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = "order:" + v301 + ";";
        cached = v302;
        stage1();
    }

    private static void stage1() {
        String v303 = cached;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        Handler04Dispatcher.apply(v304);
    }
}
