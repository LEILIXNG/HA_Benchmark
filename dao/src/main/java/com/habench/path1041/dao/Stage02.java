package com.habench.path1041.dao;

import com.habench.path1041.dao.SinkHandler;
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
        String v201 = value;
        String v202 = "order:" + v201 + ";";
        this.carried = v202;
        stage1();
    }

    private void stage1() {
        String v203 = this.carried;
        String v204 = "order:" + v203 + ";";
        String v205 = v204;
        cached = v205;
        stage2();
    }

    private void stage2() {
        String v206 = cached;
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        this.carried = v207;
        stage3();
    }

    private void stage3() {
        String v208 = this.carried;
        Map<String, String> attrs209 = new HashMap<String, String>();
        attrs209.put("channel", "web");
        attrs209.put("payload", v208);
        String v209 = attrs209.get("payload");
        this.carried = v209;
        stage4();
    }

    private void stage4() {
        String v210 = this.carried;
        String v211 = "order:" + v210 + ";";
        String v212 = v211;
        SinkHandler.execute(v212);
    }
}
