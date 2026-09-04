package com.habench.sqli1016.service;

import com.habench.sqli1016.service.Handler02Dispatcher;

public final class Stage01 {
    private static String cached;

    public static void handle(String value) {
        String v101 = value;
        String v102 = v101;
        cached = v102;
        stage1();
    }

    private static void stage1() {
        String v103 = cached;
        String v104 = v103;
        Handler02Dispatcher.apply(v104);
    }
}
