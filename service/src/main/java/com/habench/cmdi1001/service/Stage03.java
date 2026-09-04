package com.habench.cmdi1001.service;

import com.habench.cmdi1001.dao.Stage04;
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
        String v304 = "order:" + v303 + ";";
        Map<String, String> attrs305 = new HashMap<String, String>();
        attrs305.put("channel", "web");
        attrs305.put("payload", v304);
        String v305 = attrs305.get("payload");
        Stage04.handle(v305);
    }
}
