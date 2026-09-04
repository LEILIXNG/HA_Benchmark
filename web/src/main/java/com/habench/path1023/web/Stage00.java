package com.habench.path1023.web;

import com.habench.path1023.web.Handler01Dispatcher;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        String v2 = v1;
        Handler01Dispatcher.apply(v2);
    }
}
