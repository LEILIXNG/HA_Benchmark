package com.habench.sqli1051.web;

import com.habench.sqli1051.service.Stage01;
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
        cached = v1;
        stage1();
    }

    private void stage1() {
        String v2 = cached;
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
        cached = v3;
        stage2();
    }

    private void stage2() {
        String v4 = cached;
        String v5 = v4;
        this.carried = v5;
        stage3();
    }

    private void stage3() {
        String v6 = this.carried;
        Map<String, String> attrs7 = new HashMap<String, String>();
        attrs7.put("channel", "web");
        attrs7.put("payload", v6);
        String v7 = attrs7.get("payload");
        cached = v7;
        stage4();
    }

    private void stage4() {
        String v8 = cached;
        String v9 = v8;
        String v10 = v9;
        cached = v10;
        stage5();
    }

    private void stage5() {
        String v11 = cached;
        String v12 = "order:" + v11 + ";";
        Stage01.handle(v12);
    }
}
