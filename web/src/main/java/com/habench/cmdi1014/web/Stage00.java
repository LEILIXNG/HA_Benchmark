package com.habench.cmdi1014.web;

import com.habench.cmdi1014.web.Stage01;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = "order:" + v1 + ";";
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = "order:" + v3 + ";";
        Stage01.handle(v4);
    }
}
