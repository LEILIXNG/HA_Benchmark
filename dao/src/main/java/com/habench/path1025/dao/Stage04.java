package com.habench.path1025.dao;

import com.habench.path1025.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        cached = v401;
        stage1();
    }

    private static void stage1() {
        String v402 = cached;
        String v403 = v402;
        Map<String, String> attrs404 = new HashMap<String, String>();
        attrs404.put("channel", "web");
        attrs404.put("payload", v403);
        String v404 = attrs404.get("payload");
        SinkHandler.execute(v404);
    }
}
