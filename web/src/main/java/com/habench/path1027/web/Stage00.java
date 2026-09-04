package com.habench.path1027.web;

import com.habench.path1027.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = value;
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = "order:" + v2 + ";";
        cached = v3;
        stage2();
    }

    private void stage2() {
        String v4 = cached;
        String v5 = v4;
        String v6 = v5;
        cached = v6;
        stage3();
    }

    private void stage3() {
        String v7 = cached;
        Map<String, String> attrs8 = new HashMap<String, String>();
        attrs8.put("channel", "web");
        attrs8.put("payload", v7);
        String v8 = attrs8.get("payload");
        Stage01.handle(v8);
    }
}
