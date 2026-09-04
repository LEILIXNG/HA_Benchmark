package com.habench.cmdi0002.dao;

import com.habench.cmdi0002.dao.SinkHandler;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        cached = value;
        stage1();
    }

    private static void stage1() {
        String v301 = cached;
        SinkHandler.execute(v301);
    }
}
