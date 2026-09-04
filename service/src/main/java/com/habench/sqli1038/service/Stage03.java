package com.habench.sqli1038.service;

import com.habench.sqli1038.service.Handler04Dispatcher;

public final class Stage03 {

    public static void handle(String value) {
        String v301 = value;
        String v302 = "order:" + v301 + ";";
        Handler04Dispatcher.apply(v302);
    }
}
