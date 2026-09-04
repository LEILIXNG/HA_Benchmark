package com.habench.cmdi1052.dao;

import com.habench.cmdi1052.dao.Handler04Dispatcher;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = value;
        cached = v301;
        stage1();
    }

    private static void stage1() {
        String v302 = cached;
        String v303 = "order:" + v302 + ";";
        cached = v303;
        stage2();
    }

    private static void stage2() {
        String v304 = cached;
        Map<String, String> attrs305 = new HashMap<String, String>();
        attrs305.put("channel", "web");
        attrs305.put("payload", v304);
        String v305 = attrs305.get("payload");
        Handler04Dispatcher.apply(v305);
    }
}
