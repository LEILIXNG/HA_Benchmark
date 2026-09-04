package com.habench.sqli1055n.dao;

import com.habench.sqli1055n.dao.Sanitizer06;
import java.util.HashMap;
import java.util.Map;

public final class Stage05 {

    public static void handle(String value) {
        Map<String, String> attrs501 = new HashMap<String, String>();
        attrs501.put("channel", "web");
        attrs501.put("payload", value);
        String v501 = attrs501.get("payload");
        String v502 = v501;
        Sanitizer06.apply(v502);
    }
}
