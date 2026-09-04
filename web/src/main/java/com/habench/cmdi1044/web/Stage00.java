package com.habench.cmdi1044.web;

import com.habench.cmdi1044.service.Stage01;
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
        cached = v1;
        stage1();
    }

    private void stage1() {
        String v2 = cached;
        String v3 = v2;
        String v4 = v3;
        this.carried = v4;
        stage2();
    }

    private void stage2() {
        String v5 = this.carried;
        String v6 = "order:" + v5 + ";";
        Map<String, String> attrs7 = new HashMap<String, String>();
        attrs7.put("channel", "web");
        attrs7.put("payload", v6);
        String v7 = attrs7.get("payload");
        Stage01.handle(v7);
    }
}
