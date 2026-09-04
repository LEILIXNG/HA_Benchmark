package com.habench.cmdi1015.web;

import com.habench.cmdi1015.web.Stage01;
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
        String v4 = v3;
        cached = v4;
        stage2();
    }

    private void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        Map<String, String> attrs7 = new HashMap<String, String>();
        attrs7.put("channel", "web");
        attrs7.put("payload", v6);
        String v7 = attrs7.get("payload");
        this.carried = v7;
        stage3();
    }

    private void stage3() {
        String v8 = this.carried;
        Map<String, String> attrs9 = new HashMap<String, String>();
        attrs9.put("channel", "web");
        attrs9.put("payload", v8);
        String v9 = attrs9.get("payload");
        this.carried = v9;
        stage4();
    }

    private void stage4() {
        String v10 = this.carried;
        Map<String, String> attrs11 = new HashMap<String, String>();
        attrs11.put("channel", "web");
        attrs11.put("payload", v10);
        String v11 = attrs11.get("payload");
        Stage01.handle(v11);
    }
}
