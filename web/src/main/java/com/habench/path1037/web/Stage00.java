package com.habench.path1037.web;

import com.habench.path1037.web.Stage01;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = value;
        cached = v1;
        stage1();
    }

    private static void stage1() {
        String v2 = cached;
        String v3 = "order:" + v2 + ";";
        String v4 = v3;
        Stage01.apply(v4);
    }
}
