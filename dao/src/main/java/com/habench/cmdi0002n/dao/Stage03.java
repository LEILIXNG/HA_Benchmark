package com.habench.cmdi0002n.dao;

import com.habench.cmdi0002n.dao.Sanitizer04;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        cached = value;
        stage1();
    }

    private static void stage1() {
        String v301 = cached;
        Sanitizer04.apply(v301);
    }
}
