package com.habench.cmdi1002.web;

import com.habench.cmdi1002.service.Stage03;

public final class Stage02 {
    private static String cached;

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        cached = v201;
        stage1();
    }

    private static void stage1() {
        String v202 = cached;
        String v203 = "order:" + v202 + ";";
        Stage03.handle(v203);
    }
}
