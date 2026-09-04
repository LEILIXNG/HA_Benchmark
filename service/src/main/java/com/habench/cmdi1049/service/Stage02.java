package com.habench.cmdi1049.service;

import com.habench.cmdi1049.service.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage02 {
    private String carried;

    public static void apply(String value) {
        Stage02 self = new Stage02();
        self.handle(value);
    }

    private void handle(String value) {
        String v201 = value;
        this.carried = v201;
        stage1();
    }

    private void stage1() {
        String v202 = this.carried;
        String v203 = v202;
        String v204 = "order:" + v203 + ";";
        this.carried = v204;
        stage2();
    }

    private void stage2() {
        String v205 = this.carried;
        String v206 = "order:" + v205 + ";";
        Map<String, String> attrs207 = new HashMap<String, String>();
        attrs207.put("channel", "web");
        attrs207.put("payload", v206);
        String v207 = attrs207.get("payload");
        SinkHandler.execute(v207);
    }
}
