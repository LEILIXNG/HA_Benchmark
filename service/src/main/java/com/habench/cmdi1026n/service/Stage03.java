package com.habench.cmdi1026n.service;

import com.habench.cmdi1026n.dao.Stage04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = value;
        cached = v301;
        stage1();
    }

    private static void stage1() {
        String v302 = cached;
        Map<String, String> attrs303 = new HashMap<String, String>();
        attrs303.put("channel", "web");
        attrs303.put("payload", v302);
        String v303 = attrs303.get("payload");
        Stage04.handle(v303);
    }
}
