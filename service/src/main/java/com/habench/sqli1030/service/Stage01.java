package com.habench.sqli1030.service;

import com.habench.sqli1030.service.Stage02;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        cached = v101;
        stage1();
    }

    private static void stage1() {
        String v102 = cached;
        String v103 = "order:" + v102 + ";";
        Stage02.apply(v103);
    }
}
