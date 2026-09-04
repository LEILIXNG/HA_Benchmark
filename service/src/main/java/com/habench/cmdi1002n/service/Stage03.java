package com.habench.cmdi1002n.service;

import com.habench.cmdi1002n.dao.Stage04;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        cached = v301;
        stage1();
    }

    private static void stage1() {
        String v302 = cached;
        String v303 = "order:" + v302 + ";";
        Stage04.handle(v303);
    }
}
