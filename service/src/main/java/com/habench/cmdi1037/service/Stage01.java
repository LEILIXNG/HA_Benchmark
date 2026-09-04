package com.habench.cmdi1037.service;

import com.habench.cmdi1037.dao.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs101 = new HashMap<String, String>();
        attrs101.put("channel", "web");
        attrs101.put("payload", value);
        String v101 = attrs101.get("payload");
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        Map<String, String> attrs104 = new HashMap<String, String>();
        attrs104.put("channel", "web");
        attrs104.put("payload", v103);
        String v104 = attrs104.get("payload");
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        this.carried = v105;
        stage2();
    }

    private void stage2() {
        String v106 = this.carried;
        Map<String, String> attrs107 = new HashMap<String, String>();
        attrs107.put("channel", "web");
        attrs107.put("payload", v106);
        String v107 = attrs107.get("payload");
        Map<String, String> attrs108 = new HashMap<String, String>();
        attrs108.put("channel", "web");
        attrs108.put("payload", v107);
        String v108 = attrs108.get("payload");
        cached = v108;
        stage3();
    }

    private void stage3() {
        String v109 = cached;
        String v110 = "order:" + v109 + ";";
        Stage02.apply(v110);
    }
}
