package com.habench.sqli1079.dao;

import com.habench.sqli1079.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private String carried;

    public static void apply(String value) {
        Stage03 self = new Stage03();
        self.handle(value);
    }

    private void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        this.carried = v302;
        stage1();
    }

    private void stage1() {
        String v303 = this.carried;
        String v304 = "order:" + v303 + ";";
        this.carried = v304;
        stage2();
    }

    private void stage2() {
        String v305 = this.carried;
        String v306 = v305;
        this.carried = v306;
        stage3();
    }

    private void stage3() {
        String v307 = this.carried;
        String v308 = "order:" + v307 + ";";
        SinkHandler.execute(v308);
    }
}
