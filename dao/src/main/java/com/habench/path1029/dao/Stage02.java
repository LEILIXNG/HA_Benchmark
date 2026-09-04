package com.habench.path1029.dao;

import com.habench.path1029.dao.SinkHandler;
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
        Map<String, String> attrs204 = new HashMap<String, String>();
        attrs204.put("channel", "web");
        attrs204.put("payload", v203);
        String v204 = attrs204.get("payload");
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        String v206 = v205;
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        SinkHandler.execute(v207);
    }
}
