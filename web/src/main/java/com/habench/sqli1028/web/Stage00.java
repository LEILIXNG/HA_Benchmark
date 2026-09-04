package com.habench.sqli1028.web;

import com.habench.sqli1028.service.Stage01;
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
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        cached = v2;
        stage1();
    }

    private void stage1() {
        String v3 = cached;
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        String v5 = "order:" + v4 + ";";
        cached = v5;
        stage2();
    }

    private void stage2() {
        String v6 = cached;
        String v7 = v6;
        cached = v7;
        stage3();
    }

    private void stage3() {
        String v8 = cached;
        String v9 = v8;
        String v10 = v9;
        this.carried = v10;
        stage4();
    }

    private void stage4() {
        String v11 = this.carried;
        Map<String, String> attrs12 = new HashMap<String, String>();
        attrs12.put("channel", "web");
        attrs12.put("payload", v11);
        String v12 = attrs12.get("payload");
        Stage01.handle(v12);
    }
}
