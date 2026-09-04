package com.habench.cmdi1034.dao;

import com.habench.cmdi1034.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {

    public static void handle(String value) {
        String v401 = value;
        Map<String, String> attrs402 = new HashMap<String, String>();
        attrs402.put("channel", "web");
        attrs402.put("payload", v401);
        String v402 = attrs402.get("payload");
        SinkHandler.execute(v402);
    }
}
