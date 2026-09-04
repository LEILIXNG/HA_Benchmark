package com.habench.path1049.web;

import com.habench.path1049.web.Handler02Dispatcher;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = "order:" + value + ";";
        Handler02Dispatcher.apply(v101);
    }
}
