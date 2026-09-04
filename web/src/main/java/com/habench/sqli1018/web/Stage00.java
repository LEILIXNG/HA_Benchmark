package com.habench.sqli1018.web;

import com.habench.sqli1018.web.Handler01Dispatcher;
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
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = "order:" + v3 + ";";
        String v5 = v4;
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
        Map<String, String> attrs10 = new HashMap<String, String>();
        attrs10.put("channel", "web");
        attrs10.put("payload", v9);
        String v10 = attrs10.get("payload");
        Handler01Dispatcher.apply(v10);
    }
}
