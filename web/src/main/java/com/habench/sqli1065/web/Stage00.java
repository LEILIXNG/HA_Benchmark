package com.habench.sqli1065.web;

import com.habench.sqli1065.service.Stage01;
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
        cached = v1;
        stage1();
    }

    private void stage1() {
        String v2 = cached;
        String v3 = "order:" + v2 + ";";
        String v4 = "order:" + v3 + ";";
        cached = v4;
        stage2();
    }

    private void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        String v7 = "order:" + v6 + ";";
        this.carried = v7;
        stage3();
    }

    private void stage3() {
        String v8 = this.carried;
        String v9 = "order:" + v8 + ";";
        this.carried = v9;
        stage4();
    }

    private void stage4() {
        String v10 = this.carried;
        String v11 = "order:" + v10 + ";";
        Stage01.handle(v11);
    }
}
