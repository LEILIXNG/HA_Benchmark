package com.habench.sqli1021.web;

import com.habench.sqli1021.service.Stage01;
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
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = "order:" + v3 + ";";
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        cached = v5;
        stage2();
    }

    private void stage2() {
        String v6 = cached;
        String v7 = "order:" + v6 + ";";
        cached = v7;
        stage3();
    }

    private void stage3() {
        String v8 = cached;
        String v9 = v8;
        String v10 = "order:" + v9 + ";";
        this.carried = v10;
        stage4();
    }

    private void stage4() {
        String v11 = this.carried;
        Map<String, String> attrs12 = new HashMap<String, String>();
        attrs12.put("channel", "web");
        attrs12.put("payload", v11);
        String v12 = attrs12.get("payload");
        String v13 = "order:" + v12 + ";";
        Stage01.handle(v13);
    }
}
