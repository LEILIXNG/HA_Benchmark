package com.habench.cmdi1009.web;

import com.habench.cmdi1009.web.Handler01Dispatcher;
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
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = "order:" + v2 + ";";
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        cached = v4;
        stage2();
    }

    private void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        cached = v6;
        stage3();
    }

    private void stage3() {
        String v7 = cached;
        Map<String, String> attrs8 = new HashMap<String, String>();
        attrs8.put("channel", "web");
        attrs8.put("payload", v7);
        String v8 = attrs8.get("payload");
        String v9 = v8;
        Handler01Dispatcher.apply(v9);
    }
}
