package com.habench.path1039.dao;

import com.habench.path1039.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        cached = v302;
        stage1();
    }

    private static void stage1() {
        String v303 = cached;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        String v305 = "order:" + v304 + ";";
        cached = v305;
        stage2();
    }

    private static void stage2() {
        String v306 = cached;
        String v307 = "order:" + v306 + ";";
        String v308 = "order:" + v307 + ";";
        SinkHandler.execute(v308);
    }
}
