package com.habench.sqli1072.dao;

import com.habench.sqli1072.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;
    private static String cached;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = "order:" + v301 + ";";
        cached = v302;
        stage1();
    }

    private void stage1() {
        String v303 = cached;
        String v304 = "order:" + v303 + ";";
        Map<String, String> attrs305 = new HashMap<String, String>();
        attrs305.put("channel", "web");
        attrs305.put("payload", v304);
        String v305 = attrs305.get("payload");
        this.carried = v305;
        stage2();
    }

    private void stage2() {
        String v306 = this.carried;
        String v307 = "order:" + v306 + ";";
        String v308 = "order:" + v307 + ";";
        cached = v308;
        stage3();
    }

    private void stage3() {
        String v309 = cached;
        String v310 = v309;
        String v311 = v310;
        this.carried = v311;
        stage4();
    }

    private void stage4() {
        String v312 = this.carried;
        String v313 = "order:" + v312 + ";";
        String v314 = v313;
        this.carried = v314;
        stage5();
    }

    private void stage5() {
        String v315 = this.carried;
        String v316 = v315;
        this.carried = v316;
        stage6();
    }

    private void stage6() {
        String v317 = this.carried;
        String v318 = "order:" + v317 + ";";
        String v319 = v318;
        SinkHandler.execute(v319);
    }
}
