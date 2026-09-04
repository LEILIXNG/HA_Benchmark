package com.habench.sqli1057.web;

import com.habench.sqli1057.web.Handler01Dispatcher;

public final class Stage00 {

    public static void handle(String value) {
        String v1 = "order:" + value + ";";
        Handler01Dispatcher.apply(v1);
    }
}
