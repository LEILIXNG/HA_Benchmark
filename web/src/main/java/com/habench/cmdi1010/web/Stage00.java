package com.habench.cmdi1010.web;

import com.habench.cmdi1010.web.Handler01Dispatcher;

public final class Stage00 {
    private static String cached;

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = v1;
        cached = v2;
        stage1();
    }

    private static void stage1() {
        String v3 = cached;
        String v4 = "order:" + v3 + ";";
        String v5 = "order:" + v4 + ";";
        Handler01Dispatcher.apply(v5);
    }
}
