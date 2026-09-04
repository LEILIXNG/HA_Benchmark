package com.habench.cmdi1035.web;

import com.habench.cmdi1035.service.Stage01;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = value;
        String v2 = v1;
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = v3;
        Stage01.handle(v4);
    }
}
