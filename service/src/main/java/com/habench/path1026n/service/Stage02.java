package com.habench.path1026n.service;

import com.habench.path1026n.dao.Stage03;
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
        String v202 = "order:" + v201 + ";";
        cached = v202;
        stage1();
    }

    private void stage1() {
        String v203 = cached;
        String v204 = v203;
        Map<String, String> attrs205 = new HashMap<String, String>();
        attrs205.put("channel", "web");
        attrs205.put("payload", v204);
        String v205 = attrs205.get("payload");
        this.carried = v205;
        stage2();
    }

    private void stage2() {
        String v206 = this.carried;
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        Stage03.apply(v207);
    }
}
