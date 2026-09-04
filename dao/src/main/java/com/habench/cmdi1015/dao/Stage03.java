package com.habench.cmdi1015.dao;

import com.habench.cmdi1015.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = "order:" + v301 + ";";
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        cached = v304;
        stage2();
    }

    private void stage2() {
        String v305 = cached;
        Map<String, String> attrs306 = new HashMap<String, String>();
        attrs306.put("channel", "web");
        attrs306.put("payload", v305);
        String v306 = attrs306.get("payload");
        SinkHandler.execute(v306);
    }
}
