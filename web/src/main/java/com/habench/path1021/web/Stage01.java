package com.habench.path1021.web;

import com.habench.path1021.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        cached = v101;
        stage1();
    }

    private static void stage1() {
        String v102 = cached;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        cached = v103;
        stage2();
    }

    private static void stage2() {
        String v104 = cached;
        String v105 = v104;
        cached = v105;
        stage3();
    }

    private static void stage3() {
        String v106 = cached;
        String v107 = v106;
        String v108 = v107;
        cached = v108;
        stage4();
    }

    private static void stage4() {
        String v109 = cached;
        String v110 = v109;
        String v111 = "order:" + v110 + ";";
        cached = v111;
        stage5();
    }

    private static void stage5() {
        String v112 = cached;
        String v113 = "order:" + v112 + ";";
        Stage02.apply(v113);
    }
}
