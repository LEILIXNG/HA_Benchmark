package com.habench.cmdi1060.dao;

import com.habench.cmdi1060.dao.Stage04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        cached = v301;
        stage1();
    }

    private static void stage1() {
        String v302 = cached;
        String v303 = v302;
        String v304 = "order:" + v303 + ";";
        cached = v304;
        stage2();
    }

    private static void stage2() {
        String v305 = cached;
        String v306 = "order:" + v305 + ";";
        String v307 = v306;
        Stage04.handle(v307);
    }
}
