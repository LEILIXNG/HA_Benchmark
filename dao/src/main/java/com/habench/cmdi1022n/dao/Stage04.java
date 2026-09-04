package com.habench.cmdi1022n.dao;

import com.habench.cmdi1022n.dao.Sanitizer05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {

    public static void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        Sanitizer05.apply(v401);
    }
}
