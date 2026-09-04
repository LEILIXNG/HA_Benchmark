package com.habench.sqli0001n.dao;

import com.habench.sqli0001n.dao.Sanitizer04;
import java.util.HashMap;
import java.util.Map;

public final class Stage03 {

    public static void handle(String value) {
        Map<String, String> attrs301 = new HashMap<String, String>();
        attrs301.put("channel", "web");
        attrs301.put("payload", value);
        String v301 = attrs301.get("payload");
        Sanitizer04.apply(v301);
    }
}
