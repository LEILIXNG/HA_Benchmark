package com.habench.path1012.service;

import com.habench.path1012.service.Handler02Dispatcher;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Handler02Dispatcher.apply(v101);
    }
}
