package com.habench.cmdi1008.web;

import com.habench.cmdi1008.web.Stage01;
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
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        Map<String, String> attrs2 = new HashMap<String, String>();
        attrs2.put("channel", "web");
        attrs2.put("payload", v1);
        String v2 = attrs2.get("payload");
        this.carried = v2;
        stage1();
    }

    private void stage1() {
        String v3 = this.carried;
        String v4 = v3;
        String v5 = v4;
        this.carried = v5;
        stage2();
    }

    private void stage2() {
        String v6 = this.carried;
        Map<String, String> attrs7 = new HashMap<String, String>();
        attrs7.put("channel", "web");
        attrs7.put("payload", v6);
        String v7 = attrs7.get("payload");
        cached = v7;
        stage3();
    }

    private void stage3() {
        String v8 = cached;
        String v9 = v8;
        Stage01.handle(v9);
    }
}
