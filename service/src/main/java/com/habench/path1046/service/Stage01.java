package com.habench.path1046.service;

import com.habench.path1046.service.SinkHandler;
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
        String v102 = v101;
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        String v105 = v104;
        this.carried = v105;
        stage2();
    }

    private void stage2() {
        String v106 = this.carried;
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        Map<String, String> attrs108 = new HashMap<String, String>();
        attrs108.put("channel", "web");
        attrs108.put("payload", v107);
        String v108 = attrs108.get("payload");
        cached = v108;
        stage3();
    }

    private void stage3() {
        String v109 = cached;
        String v110 = v109;
        Map<String, String> attrs111 = new HashMap<String, String>();
        attrs111.put("channel", "web");
        attrs111.put("payload", v110);
        String v111 = attrs111.get("payload");
        SinkHandler.execute(v111);
    }
}
