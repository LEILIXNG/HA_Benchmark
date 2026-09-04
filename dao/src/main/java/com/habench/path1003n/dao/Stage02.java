package com.habench.path1003n.dao;

import com.habench.path1003n.dao.Stage03;
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
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        Map<String, String> attrs203 = new HashMap<String, String>();
        attrs203.put("channel", "web");
        attrs203.put("payload", v202);
        String v203 = attrs203.get("payload");
        cached = v203;
        stage2();
    }

    private void stage2() {
        String v204 = cached;
        String v205 = "order:" + v204 + ";";
        String v206 = v205;
        Stage03.handle(v206);
    }
}
