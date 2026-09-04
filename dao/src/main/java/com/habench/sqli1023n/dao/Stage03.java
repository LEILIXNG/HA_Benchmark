package com.habench.sqli1023n.dao;

import com.habench.sqli1023n.dao.SinkHandler;
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
        String v301 = value;
        String v302 = v301;
        cached = v302;
        stage1();
    }

    private void stage1() {
        String v303 = cached;
        Map<String, String> attrs304 = new HashMap<String, String>();
        attrs304.put("channel", "web");
        attrs304.put("payload", v303);
        String v304 = attrs304.get("payload");
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = "order:" + v305 + ";";
        SinkHandler.execute(v306);
    }
}
