package com.habench.cmdi1006.web;

import com.habench.cmdi1006.service.Stage01;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        cached = v1;
        stage1();
    }

    private static void stage1() {
        String v2 = cached;
        String v3 = v2;
        Stage01.handle(v3);
    }
}
