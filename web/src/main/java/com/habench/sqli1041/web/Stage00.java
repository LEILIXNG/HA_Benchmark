package com.habench.sqli1041.web;

import com.habench.sqli1041.service.Stage01;
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
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        cached = v2;
        stage1();
    }

    private void stage1() {
        String v3 = cached;
        String v4 = v3;
        cached = v4;
        stage2();
    }

    private void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        this.carried = v6;
        stage3();
    }

    private void stage3() {
        String v7 = this.carried;
        String v8 = v7;
        Map<String, String> attrs9 = new HashMap<String, String>();
        attrs9.put("channel", "web");
        attrs9.put("payload", v8);
        String v9 = attrs9.get("payload");
        cached = v9;
        stage4();
    }

    private void stage4() {
        String v10 = cached;
        Map<String, String> attrs11 = new HashMap<String, String>();
        attrs11.put("channel", "web");
        attrs11.put("payload", v10);
        String v11 = attrs11.get("payload");
        cached = v11;
        stage5();
    }

    private void stage5() {
        String v12 = cached;
        String v13 = v12;
        Map<String, String> attrs14 = new HashMap<String, String>();
        attrs14.put("channel", "web");
        attrs14.put("payload", v13);
        String v14 = attrs14.get("payload");
        cached = v14;
        stage6();
    }

    private void stage6() {
        String v15 = cached;
        String v16 = "order:" + v15 + ";";
        String v17 = v16;
        Stage01.handle(v17);
    }
}
