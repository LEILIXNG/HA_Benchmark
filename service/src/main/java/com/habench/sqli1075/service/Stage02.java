package com.habench.sqli1075.service;

import com.habench.sqli1075.dao.Stage03;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs201 = new HashMap<String, String>();
        attrs201.put("channel", "web");
        attrs201.put("payload", value);
        String v201 = attrs201.get("payload");
        String v202 = "order:" + v201 + ";";
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = "order:" + v203 + ";";
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        String v206 = v205;
        String v207 = v206;
        Stage03.apply(v207);
    }
}
