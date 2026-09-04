package com.habench.path1047.dao;

import com.habench.path1047.dao.Stage04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {

    public static void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        Map<String, String> attrs302 = new HashMap<String, String>();
        attrs302.put("channel", "web");
        attrs302.put("payload", v301);
        String v302 = attrs302.get("payload");
        Stage04.handle(v302);
    }
}
