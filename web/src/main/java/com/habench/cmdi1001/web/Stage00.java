package com.habench.cmdi1001.web;

import com.habench.cmdi1001.service.Stage01;
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
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
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
        Map<String, String> attrs8 = new HashMap<String, String>();
        attrs8.put("channel", "web");
        attrs8.put("payload", v7);
        String v8 = attrs8.get("payload");
        Stage01.handle(v8);
    }
}
