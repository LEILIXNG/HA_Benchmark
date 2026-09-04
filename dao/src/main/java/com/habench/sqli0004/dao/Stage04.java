package com.habench.sqli0004.dao;

import com.habench.sqli0004.dao.Stage05;

public final class Stage04 {
    private static String cached;

    public static void handle(String value) {
        cached = value;
        stage1();
    }

    private static void stage1() {
        String v401 = cached;
        Stage05.handle(v401);
    }
}
