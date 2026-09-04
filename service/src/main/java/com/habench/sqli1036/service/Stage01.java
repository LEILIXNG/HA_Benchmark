package com.habench.sqli1036.service;

import com.habench.sqli1036.service.Sanitizer02;
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
        String v101 = "order:" + value + ";";
        String v102 = "order:" + v101 + ";";
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = v103;
        cached = v104;
        stage2();
    }

    private void stage2() {
        String v105 = cached;
        String v106 = v105;
        String v107 = v106;
        this.carried = v107;
        stage3();
    }

    private void stage3() {
        String v108 = this.carried;
        String v109 = "order:" + v108 + ";";
        this.carried = v109;
        stage4();
    }

    private void stage4() {
        String v110 = this.carried;
        Map<String, String> attrs111 = new HashMap<String, String>();
        attrs111.put("channel", "web");
        attrs111.put("payload", v110);
        String v111 = attrs111.get("payload");
        this.carried = v111;
        stage5();
    }

    private void stage5() {
        String v112 = this.carried;
        String v113 = "order:" + v112 + ";";
        Map<String, String> attrs114 = new HashMap<String, String>();
        attrs114.put("channel", "web");
        attrs114.put("payload", v113);
        String v114 = attrs114.get("payload");
        cached = v114;
        stage6();
    }

    private void stage6() {
        String v115 = cached;
        Map<String, String> attrs116 = new HashMap<String, String>();
        attrs116.put("channel", "web");
        attrs116.put("payload", v115);
        String v116 = attrs116.get("payload");
        String v117 = "order:" + v116 + ";";
        Sanitizer02.apply(v117);
    }
}
