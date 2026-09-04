package com.habench.sqli1007.dao;

import com.habench.sqli1007.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage06 {

    public static void handle(String value) {
        Map<String, String> attrs601 = new HashMap<String, String>();
        attrs601.put("channel", "web");
        attrs601.put("payload", value);
        String v601 = attrs601.get("payload");
        SinkHandler.execute(v601);
    }
}
