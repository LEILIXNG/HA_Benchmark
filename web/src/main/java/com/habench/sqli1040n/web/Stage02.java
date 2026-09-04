package com.habench.sqli1040n.web;

import com.habench.sqli1040n.web.Handler03Dispatcher;

public final class Stage02 {

    public static void handle(String value) {
        String v201 = "order:" + value + ";";
        String v202 = v201;
        Handler03Dispatcher.apply(v202);
    }
}
