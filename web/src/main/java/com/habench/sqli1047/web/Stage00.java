package com.habench.sqli1047.web;

import com.habench.sqli1047.service.Stage01;

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
        String v4 = v3;
        Stage01.handle(v4);
    }
}
