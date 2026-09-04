package com.habench.sqli1009.web;

import com.habench.sqli1009.service.Stage01;

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
        cached = v3;
        stage2();
    }

    private static void stage2() {
        String v4 = cached;
        String v5 = v4;
        Stage01.apply(v5);
    }
}
