package com.habench.sqli1017n.dao;

import com.habench.sqli1017n.dao.SinkHandler;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = value;
        String v302 = v301;
        cached = v302;
        stage1();
    }

    private static void stage1() {
        String v303 = cached;
        String v304 = v303;
        SinkHandler.execute(v304);
    }
}
