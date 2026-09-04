package com.habench.path1045.web;

import com.habench.path1045.web.Handler01Dispatcher;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Handler01Dispatcher.apply(v1);
    }
}
