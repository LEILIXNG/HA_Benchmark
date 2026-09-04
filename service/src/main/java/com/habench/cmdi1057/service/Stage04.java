package com.habench.cmdi1057.service;

import com.habench.cmdi1057.dao.Stage05;
import java.util.HashMap;
import java.util.Map;

public final class Stage04 {
    private static String cached;

    public static void handle(String value) {
        Map<String, String> attrs401 = new HashMap<String, String>();
        attrs401.put("channel", "web");
        attrs401.put("payload", value);
        String v401 = attrs401.get("payload");
        Map<String, String> attrs402 = new HashMap<String, String>();
        attrs402.put("channel", "web");
        attrs402.put("payload", v401);
        String v402 = attrs402.get("payload");
        cached = v402;
        stage1();
    }

    private static void stage1() {
        String v403 = cached;
        Map<String, String> attrs404 = new HashMap<String, String>();
        attrs404.put("channel", "web");
        attrs404.put("payload", v403);
        String v404 = attrs404.get("payload");
        String v405 = v404;
        Stage05.handle(v405);
    }
}
