package com.habench.path1003n.service;

import com.habench.path1003n.dao.Stage02;
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
        Map<String, String> attrs103 = new HashMap<String, String>();
        attrs103.put("channel", "web");
        attrs103.put("payload", v102);
        String v103 = attrs103.get("payload");
        cached = v103;
        stage2();
    }

    private void stage2() {
        String v104 = cached;
        String v105 = v104;
        this.carried = v105;
        stage3();
    }

    private void stage3() {
        String v106 = this.carried;
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        Stage02.apply(v107);
    }
}
