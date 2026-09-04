package com.habench.path1001.service;

import com.habench.path1001.dao.Stage02;
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
        String v101 = value;
        this.carried = v101;
        stage1();
    }

    private void stage1() {
        String v102 = this.carried;
        String v103 = v102;
        cached = v103;
        stage2();
    }

    private void stage2() {
        String v104 = cached;
        Map<String, String> attrs105 = new HashMap<String, String>();
        attrs105.put("channel", "web");
        attrs105.put("payload", v104);
        String v105 = attrs105.get("payload");
        Stage02.apply(v105);
    }
}
