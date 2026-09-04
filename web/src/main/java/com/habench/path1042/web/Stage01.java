package com.habench.path1042.web;

import com.habench.path1042.service.Stage02;
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
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = v102;
        String v104 = "order:" + v103 + ";";
        this.carried = v104;
        stage2();
    }

    private void stage2() {
        String v105 = this.carried;
        String v106 = "order:" + v105 + ";";
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        cached = v107;
        stage3();
    }

    private void stage3() {
        String v108 = cached;
        String v109 = v108;
        Stage02.apply(v109);
    }
}
