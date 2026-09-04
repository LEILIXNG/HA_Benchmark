package com.habench.cmdi1018.web;

import com.habench.cmdi1018.service.Stage01;
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
        String v1 = value;
        this.carried = v1;
        stage1();
    }

    private void stage1() {
        String v2 = this.carried;
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        this.carried = v4;
        stage2();
    }

    private void stage2() {
        String v5 = this.carried;
        String v6 = "order:" + v5 + ";";
        this.carried = v6;
        stage3();
    }

    private void stage3() {
        String v7 = this.carried;
        Map<String, String> attrs8 = new HashMap<String, String>();
        attrs8.put("channel", "web");
        attrs8.put("payload", v7);
        String v8 = attrs8.get("payload");
        cached = v8;
        stage4();
    }

    private void stage4() {
        String v9 = cached;
        String v10 = v9;
        this.carried = v10;
        stage5();
    }

    private void stage5() {
        String v11 = this.carried;
        String v12 = v11;
        String v13 = v12;
        this.carried = v13;
        stage6();
    }

    private void stage6() {
        String v14 = this.carried;
        String v15 = "order:" + v14 + ";";
        Stage01.apply(v15);
    }
}
