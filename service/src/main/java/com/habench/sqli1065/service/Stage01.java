package com.habench.sqli1065.service;

import com.habench.sqli1065.service.Stage02;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        String v102 = "order:" + v101 + ";";
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = v103;
        String v105 = v104;
        Stage02.handle(v105);
    }
}
