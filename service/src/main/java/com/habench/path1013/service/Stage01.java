package com.habench.path1013.service;

import com.habench.path1013.service.SinkHandler;
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
        String v101 = "order:" + value + ";";
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        String v104 = "order:" + v103 + ";";
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        Map<String, String> attrs106 = new HashMap<String, String>();
        attrs106.put("channel", "web");
        attrs106.put("payload", v105);
        String v106 = attrs106.get("payload");
        cached = v106;
        stage3();
    }

    private void stage3() {
        String v107 = cached;
        String v108 = v107;
        SinkHandler.execute(v108);
    }
}
