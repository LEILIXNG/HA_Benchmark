package com.habench.cmdi1034n.dao;

import com.habench.cmdi1034n.dao.Handler04Dispatcher;

public final class Stage03 {
    private static String cached;

    public static void handle(String value) {
        String v301 = "order:" + value + ";";
        cached = v301;
        stage1();
    }

    private static void stage1() {
        String v302 = cached;
        String v303 = "order:" + v302 + ";";
        String v304 = v303;
        Handler04Dispatcher.apply(v304);
    }
}
