package com.habench.path1019.web;

import com.habench.path1019.service.Stage01;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = value;
        cached = v1;
        stage1();
    }

    private static void stage1() {
        String v2 = cached;
        String v3 = v2;
        Stage01.apply(v3);
    }
}
