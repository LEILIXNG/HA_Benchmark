package com.habench.cmdi1057.dao;

import com.habench.cmdi1057.dao.Sanitizer06;
import java.util.HashMap;
import java.util.Map;

public final class Stage05 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs501 = new HashMap<String, String>();
        attrs501.put("channel", "web");
        attrs501.put("payload", value);
        String v501 = attrs501.get("payload");
        cached = v501;
        stage1();
    }

    private static void stage1() {
        String v502 = cached;
        String v503 = "order:" + v502 + ";";
        String v504 = "order:" + v503 + ";";
        cached = v504;
        stage2();
    }

    private static void stage2() {
        String v505 = cached;
        Map<String, String> attrs506 = new HashMap<String, String>();
        attrs506.put("channel", "web");
        attrs506.put("payload", v505);
        String v506 = attrs506.get("payload");
        Map<String, String> attrs507 = new HashMap<String, String>();
        attrs507.put("channel", "web");
        attrs507.put("payload", v506);
        String v507 = attrs507.get("payload");
        cached = v507;
        stage3();
    }

    private static void stage3() {
        String v508 = cached;
        Map<String, String> attrs509 = new HashMap<String, String>();
        attrs509.put("channel", "web");
        attrs509.put("payload", v508);
        String v509 = attrs509.get("payload");
        Sanitizer06.apply(v509);
    }
}
