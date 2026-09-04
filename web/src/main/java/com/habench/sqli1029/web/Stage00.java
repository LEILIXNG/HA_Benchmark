package com.habench.sqli1029.web;

import com.habench.sqli1029.web.Handler01Dispatcher;
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
        String v3 = "order:" + v2 + ";";
        cached = v3;
        stage2();
    }

    private void stage2() {
        String v4 = cached;
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        this.carried = v5;
        stage3();
    }

    private void stage3() {
        String v6 = this.carried;
        String v7 = v6;
        Map<String, String> attrs8 = new HashMap<String, String>();
        attrs8.put("channel", "web");
        attrs8.put("payload", v7);
        String v8 = attrs8.get("payload");
        Handler01Dispatcher.apply(v8);
    }
}
