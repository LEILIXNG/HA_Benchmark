package com.habench.cmdi1026n.web;

import com.habench.cmdi1026n.web.Stage01;
import java.util.HashMap;
import java.util.Map;

public final class Stage00 {
    private String carried;

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
        Map<String, String> attrs3 = new HashMap<String, String>();
        attrs3.put("channel", "web");
        attrs3.put("payload", v2);
        String v3 = attrs3.get("payload");
        String v4 = "order:" + v3 + ";";
        this.carried = v4;
        stage2();
    }

    private void stage2() {
        String v5 = this.carried;
        String v6 = "order:" + v5 + ";";
        String v7 = v6;
        Stage01.apply(v7);
    }
}
