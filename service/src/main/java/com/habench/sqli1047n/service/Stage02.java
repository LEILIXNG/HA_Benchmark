package com.habench.sqli1047n.service;

import com.habench.sqli1047n.service.Handler03Dispatcher;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Handler03Dispatcher.apply(v201);
    }
}
