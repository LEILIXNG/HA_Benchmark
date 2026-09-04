package com.habench.sqli1021.dao;

import com.habench.sqli1021.dao.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;

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
        String v204 = "order:" + v203 + ";";
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        Map<String, String> attrs206 = new HashMap<String, String>();
        attrs206.put("channel", "web");
        attrs206.put("payload", v205);
        String v206 = attrs206.get("payload");
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        Stage03.handle(v207);
    }
}
