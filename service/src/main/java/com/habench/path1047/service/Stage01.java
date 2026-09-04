package com.habench.path1047.service;

import com.habench.path1047.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = value;
        cached = v101;
        stage1();
    }

    private void stage1() {
        String v102 = cached;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        String v106 = v105;
        this.carried = v106;
        stage3();
    }

    private void stage3() {
        String v107 = this.carried;
        String v108 = "order:" + v107 + ";";
        Stage02.apply(v108);
    }
}
