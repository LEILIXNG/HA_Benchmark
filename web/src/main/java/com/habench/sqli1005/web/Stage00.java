package com.habench.sqli1005.web;

import com.habench.sqli1005.web.SinkHandler;
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
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
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
        SinkHandler.execute(v7);
    }
}
