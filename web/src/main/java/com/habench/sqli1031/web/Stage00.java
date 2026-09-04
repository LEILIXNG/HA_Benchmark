package com.habench.sqli1031.web;

import com.habench.sqli1031.web.SinkHandler;
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
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = v2;
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
        String v9 = "order:" + v8 + ";";
        this.carried = v9;
        stage4();
    }

    private void stage4() {
        String v10 = this.carried;
        Map<String, String> attrs11 = new HashMap<String, String>();
        attrs11.put("channel", "web");
        attrs11.put("payload", v10);
        String v11 = attrs11.get("payload");
        cached = v11;
        stage5();
    }

    private void stage5() {
        String v12 = cached;
        String v13 = "order:" + v12 + ";";
        String v14 = "order:" + v13 + ";";
        SinkHandler.execute(v14);
    }
}
