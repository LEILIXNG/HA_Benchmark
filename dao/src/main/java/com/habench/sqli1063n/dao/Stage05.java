package com.habench.sqli1063n.dao;

import com.habench.sqli1063n.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage05 {
    private static String cached;

    public static void handle(String value) {
        String v501 = value;
        cached = v501;
        stage1();
    }

    private static void stage1() {
        String v502 = cached;
        String v503 = "order:" + v502 + ";";
        Map<String, String> attrs504 = new HashMap<String, String>();
        attrs504.put("channel", "web");
        attrs504.put("payload", v503);
        String v504 = attrs504.get("payload");
        cached = v504;
        stage2();
    }

    private static void stage2() {
        String v505 = cached;
        Map<String, String> attrs506 = new HashMap<String, String>();
        attrs506.put("channel", "web");
        attrs506.put("payload", v505);
        String v506 = attrs506.get("payload");
        cached = v506;
        stage3();
    }

    private static void stage3() {
        String v507 = cached;
        String v508 = "order:" + v507 + ";";
        SinkHandler.execute(v508);
    }
}
