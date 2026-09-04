package com.habench.cmdi1026n.web;

import com.habench.cmdi1026n.service.Stage02;
import java.util.HashMap;
import java.util.Map;

public final class Stage01 {
    private String carried;

    public static void apply(String value) {
        Stage01 self = new Stage01();
        self.handle(value);
    }

    private void handle(String value) {
        String v101 = value;
        Map<String, String> attrs102 = new HashMap<String, String>();
        attrs102.put("channel", "web");
        attrs102.put("payload", v101);
        String v102 = attrs102.get("payload");
        this.carried = v102;
        stage1();
    }

    private void stage1() {
        String v103 = this.carried;
        String v104 = "order:" + v103 + ";";
        this.carried = v104;
        stage2();
    }

    private void stage2() {
        String v105 = this.carried;
        String v106 = v105;
        this.carried = v106;
        stage3();
    }

    private void stage3() {
        String v107 = this.carried;
        String v108 = v107;
        Map<String, String> attrs109 = new HashMap<String, String>();
        attrs109.put("channel", "web");
        attrs109.put("payload", v108);
        String v109 = attrs109.get("payload");
        Stage02.handle(v109);
    }
}
