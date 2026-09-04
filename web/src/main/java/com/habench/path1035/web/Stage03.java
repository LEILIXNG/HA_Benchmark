package com.habench.path1035.web;

import com.habench.path1035.service.Stage04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = value;
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        Stage04.handle(v302);
    }
}
