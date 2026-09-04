package com.habench.cmdi1012.web;

import com.habench.cmdi1012.service.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage00 self = new Stage00();
        self.handle(value);
    }

    private void handle(String value) {
        String v1 = "order:" + value + ";";
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        String v3 = "order:" + v2 + ";";
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        cached = v4;
        stage2();
    }

    private void stage2() {
        String v5 = cached;
        String v6 = "order:" + v5 + ";";
        String v7 = "order:" + v6 + ";";
        cached = v7;
        stage3();
    }

    private void stage3() {
        String v8 = cached;
        Map<String, String> attrs9 = new HashMap<String, String>();
        attrs9.put("channel", "web");
        attrs9.put("payload", v8);
        String v9 = attrs9.get("payload");
        Map<String, String> attrs10 = new HashMap<String, String>();
        attrs10.put("channel", "web");
        attrs10.put("payload", v9);
        String v10 = attrs10.get("payload");
        cached = v10;
        stage4();
    }

    private void stage4() {
        String v11 = cached;
        String v12 = v11;
        Map<String, String> attrs13 = new HashMap<String, String>();
        attrs13.put("channel", "web");
        attrs13.put("payload", v12);
        String v13 = attrs13.get("payload");
        this.carried = v13;
        stage5();
    }

    private void stage5() {
        String v14 = this.carried;
        String v15 = "order:" + v14 + ";";
        cached = v15;
        stage6();
    }

    private void stage6() {
        String v16 = cached;
        Map<String, String> attrs17 = new HashMap<String, String>();
        attrs17.put("channel", "web");
        attrs17.put("payload", v16);
        String v17 = attrs17.get("payload");
        String v18 = "order:" + v17 + ";";
        Stage01.handle(v18);
    }
}
