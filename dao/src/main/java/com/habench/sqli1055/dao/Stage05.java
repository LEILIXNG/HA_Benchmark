package com.habench.sqli1055.dao;

import com.habench.sqli1055.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage05 {

    public static void handle(String value) {
        Map<String, String> attrs501 = new HashMap<String, String>();
        attrs501.put("channel", "web");
        attrs501.put("payload", value);
        String v501 = attrs501.get("payload");
        String v502 = v501;
        SinkHandler.execute(v502);
    }
}
