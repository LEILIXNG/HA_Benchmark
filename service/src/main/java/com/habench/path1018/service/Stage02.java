package com.habench.path1018.service;

import com.habench.path1018.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = "order:" + value + ";";
        cached = v201;
        stage1();
    }

    private void stage1() {
        String v202 = cached;
        String v203 = v202;
        this.carried = v203;
        stage2();
    }

    private void stage2() {
        String v204 = this.carried;
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        String v206 = v205;
        SinkHandler.execute(v206);
    }
}
