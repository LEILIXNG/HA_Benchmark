package com.habench.path1027n.service;

import com.habench.path1027n.dao.Stage02;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        String v102 = v101;
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = v103;
        Stage02.handle(v104);
    }
}
