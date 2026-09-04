package com.habench.sqli1061.service;

import com.habench.sqli1061.service.Handler03Dispatcher;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        Handler03Dispatcher.apply(v201);
    }
}
