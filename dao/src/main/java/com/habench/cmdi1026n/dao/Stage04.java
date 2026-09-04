package com.habench.cmdi1026n.dao;

import com.habench.cmdi1026n.dao.Sanitizer05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = value;
        Map<String, String> attrs402 = new HashMap<String, String>();
        attrs402.put("channel", "web");
        attrs402.put("payload", v401);
        String v402 = attrs402.get("payload");
        Sanitizer05.apply(v402);
    }
}
