package com.habench.path1043.web;

import com.habench.path1043.service.Stage04;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        String v302 = "order:" + v301 + ";";
        cached = v302;
        stage1();
    }

    private static void stage1() {
        String v303 = cached;
        String v304 = "order:" + v303 + ";";
        cached = v304;
        stage2();
    }

    private static void stage2() {
        String v305 = cached;
        String v306 = "order:" + v305 + ";";
        Stage04.handle(v306);
    }
}
