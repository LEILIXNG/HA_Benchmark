package com.habench.sqli1055n.dao;

import com.habench.sqli1055n.dao.Handler05Dispatcher;

public final class Stage04 {
    private static String cached;

    public static void handle(String value) {
        String v401 = value;
        cached = v401;
        stage1();
    }

    private static void stage1() {
        String v402 = cached;
        String v403 = "order:" + v402 + ";";
        String v404 = v403;
        Handler05Dispatcher.apply(v404);
    }
}
