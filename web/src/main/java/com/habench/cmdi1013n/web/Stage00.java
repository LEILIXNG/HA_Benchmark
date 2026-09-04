package com.habench.cmdi1013n.web;

import com.habench.cmdi1013n.web.Handler01Dispatcher;
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
        Map<String, String> attrs1 = new HashMap<String, String>();
        attrs1.put("channel", "web");
        attrs1.put("payload", value);
        String v1 = attrs1.get("payload");
        cached = v1;
        stage1();
    }

    private void stage1() {
        String v2 = cached;
        String v3 = v2;
        Map<String, String> attrs4 = new HashMap<String, String>();
        attrs4.put("channel", "web");
        attrs4.put("payload", v3);
        String v4 = attrs4.get("payload");
        cached = v4;
        stage2();
    }

    private void stage2() {
        String v5 = cached;
        String v6 = v5;
        cached = v6;
        stage3();
    }

    private void stage3() {
        String v7 = cached;
        String v8 = v7;
        this.carried = v8;
        stage4();
    }

    private void stage4() {
        String v9 = this.carried;
        String v10 = "order:" + v9 + ";";
        this.carried = v10;
        stage5();
    }

    private void stage5() {
        String v11 = this.carried;
        String v12 = v11;
        this.carried = v12;
        stage6();
    }

    private void stage6() {
        String v13 = this.carried;
        String v14 = "order:" + v13 + ";";
        String v15 = "order:" + v14 + ";";
        Handler01Dispatcher.apply(v15);
    }
}
