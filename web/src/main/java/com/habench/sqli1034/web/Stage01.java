package com.habench.sqli1034.web;

import com.habench.sqli1034.web.Handler02Dispatcher;

public final class Stage01 {

    public static void handle(String value) {
        String v101 = value;
        String v102 = "order:" + v101 + ";";
        Handler02Dispatcher.apply(v102);
    }
}
