package com.habench.sqli1013.web;

import com.habench.sqli1013.web.SinkHandler;
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
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
        cached = v3;
        stage2();
    }

    private void stage2() {
        String v4 = cached;
        Map<String, String> attrs5 = new HashMap<String, String>();
        attrs5.put("channel", "web");
        attrs5.put("payload", v4);
        String v5 = attrs5.get("payload");
        String v6 = "order:" + v5 + ";";
        SinkHandler.execute(v6);
    }
}
