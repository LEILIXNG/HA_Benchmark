package com.habench.path1020.web;

import com.habench.path1020.service.Stage01;
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
        String v2 = "order:" + v1 + ";";
        cached = v2;
        stage1();
    }

    private void stage1() {
        String v3 = cached;
        String v4 = v3;
        String v5 = "order:" + v4 + ";";
        this.carried = v5;
        stage2();
    }

    private void stage2() {
        String v6 = this.carried;
        Map<String, String> attrs7 = new HashMap<String, String>();
        attrs7.put("channel", "web");
        attrs7.put("payload", v6);
        String v7 = attrs7.get("payload");
        String v8 = v7;
        Stage01.handle(v8);
    }
}
